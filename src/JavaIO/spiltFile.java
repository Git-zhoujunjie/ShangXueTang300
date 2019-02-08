package JavaIO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * 封装代码 文件分割
 */
public class spiltFile {

    //源头
    private String srcPath;
    //目的地
    private String destDir;
    //所有分割后的文件路径
    private List<String> detPathList;
    //每块大小
    private int blockSize;
    //块数：多少块
    private int blockCount;

    private File file;

    public spiltFile(String srcPath, String destDir, int blockSize) {
        this.srcPath = srcPath;
        this.destDir = destDir;
        this.blockSize = blockSize;
        this.detPathList = new ArrayList<String>();

        this.file = new File(this.srcPath);

        init();
    }

    private void init() {
        long fileLen = file.length();
        this.blockCount = (int) Math.ceil(fileLen * 1.0 / blockSize); //计算块数，向上取整

        //将目的路径初始化到容器中
        for (int i = 0; i < this.blockCount; i++) {
            detPathList.add(this.destDir + "/" + i + "--" + this.file.getName()); //将目的路径存入容器
        }

        File dest = new File(this.destDir); //目的文件夹不为空时，删除目的文件夹中文件
        if (dest.listFiles() != null) {
            for (File f : dest.listFiles()) {
                f.delete();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //test3();
        //D:/JavaTest/src/ShangXueTang300/JavaIO/CopyDir.java
        spiltFile test = new spiltFile
                ("astarte.png", "D:/Sperate", 1024);
        test.split();
        test.combineFile2();
    }


    public void split() throws IOException {

        long fileLen = file.length();

        int beginPos;
        int actualSize;

        for (int i = 0; i < this.blockCount; i++) {
            beginPos = i * this.blockSize;
            if (i == this.blockCount - 1) {
                actualSize = (int) fileLen;
            } else {
                actualSize = this.blockSize;
                fileLen -= actualSize;
            }
            splitDetail(i, beginPos, actualSize);
        }
    }

    /**
     * 根据传入的参数进行文件分割
     *
     * @param i
     * @param beginPos
     * @param actualSize
     * @throws IOException
     */
    private void splitDetail(int i, int beginPos, int actualSize) throws IOException {

        try (RandomAccessFile random = new RandomAccessFile(this.srcPath, "r");
             RandomAccessFile random2 = new RandomAccessFile(this.detPathList.get(i), "rw");//写出流
        ) {
            random.seek(beginPos);//从自定直接位置进行读取

            byte[] bytes = new byte[actualSize];
            int len = -1;
            while ((len = random.read(bytes)) != -1) {
                //System.out.println(new String(bytes,0,len));
                if (len <= actualSize) {
                    //System.out.println(new String(bytes,0,len));
                    actualSize -= len;
                    random2.write(bytes, 0, len);

                } else {
                    // System.out.println(new String(bytes,0,actualSize));
                    random2.write(bytes, 0, actualSize);
                    break;
                }
            }
        }

//        random2.close();
//        random.close();
    }

    /**
     * 实现文件合并
     */
    public void combineFile() throws IOException {
        //File[] files = (new File(destDir)).listFiles();

        File df = new File("D:/Combine/"+this.file.getName());
        if(df.exists()) df.delete();
       // BufferedOutputStream b = new BufferedOutputStream(new ByteArrayOutputStream()); //现将所有字节写入到一个字节数组流中

        try (OutputStream rd = new FileOutputStream("D:/Combine/"+this.file.getName(),true);) {

            // int beginPos = 0;
            int actualSize;

//            if (files != null) {
//                for (File f : files) {
//                    //rd.seek(beginPos); //每次读取一个文件并将字节拼接到上一个文件上
//
//                    BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f));
//
//                    byte[] bytes = bis.readAllBytes();
//                    actualSize = bytes.length;
//                    rd.write(bytes, 0, actualSize);
//                    //beginPos += actualSize;
//
//                    bis.close();
//                }
//            }
            for (int i = 0; i < detPathList.size(); i++) {
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(detPathList.get(i)));

                byte[] bytes = bis.readAllBytes();
                actualSize = bytes.length;
                rd.write(bytes, 0, actualSize);
                //beginPos += actualSize;

                rd.flush(); //绝对不能少！！！！

                bis.close();
            }
        }
    }

    /**
     * 采用SequenceInputStream 实现多重输入流的读取
     * @throws IOException
     */
    public void combineFile2() throws IOException {

        File df = new File("D:/Combine/"+this.file.getName());
        if(df.exists()) df.delete();

        Vector<BufferedInputStream> vt = new Vector<>();

        for (int i = 0; i < detPathList.size(); i++) {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(detPathList.get(i)));

            vt.add(bis);
        }

        try (OutputStream rd = new FileOutputStream("D:/Combine/"+this.file.getName(),true);
             SequenceInputStream sis = new SequenceInputStream(vt.elements());) {
            int actualSize;

            byte[] bytes = new byte[1024];
            int len = -1;
            while((len=sis.read(bytes))!=-1) {
                rd.write(bytes, 0, len);
            }
            rd.flush(); //绝对不能少！！！！
            //sis.close();
        }

    }
}

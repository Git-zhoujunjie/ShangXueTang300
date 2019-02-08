package JavaIO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试随机读取和写入流RandomAccessFile
 */
public class DemoIO12 {
    public static void main(String[] args) throws IOException {
        //test3();
        RandomAccessFile random = new RandomAccessFile("D:\\JavaTest\\src\\ShangXueTang300\\JavaIO\\CopyDir.java", "r");
        //List<OutputStream> listFile = new ArrayList<>();
        long fileLen = random.length();

        int beginPos = 0;
        int blockSize = 1024;

        int blockCount = (int) Math.ceil(fileLen * 1.0 / blockSize); //计算块数，向上取整

        int actualSize = (int) (fileLen > blockSize ? blockSize : fileLen); //每块实际大小，若文件长度len小于设定的块大小，则取len
        //计算每块的长度和每块起始位置
        for (int i = 0; i < blockCount; i++) {
            beginPos = i * blockSize;
            if (i == blockCount - 1) {
                actualSize = (int) fileLen;
            } else {
                actualSize = blockSize;
                fileLen -= actualSize;
            }
            System.out.println(i + "--->" + beginPos + "--->" + actualSize);
            //计算出位置和长度后，将文件进行分割
            split(i, beginPos, actualSize);

        }
    }

    /**
     * 指定起始位置，读取剩下的所有内容
     * @throws IOException
     */
    public static void test1() throws IOException {
        RandomAccessFile random = new RandomAccessFile("11copy.txt","r");

        random.seek(2);

        byte[] bytes = new byte[1024];
        int len = -1;
        while((len = random.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }
    }

    /**
     * 指定起始位置，读取指定长度字节内容
     * @throws IOException
     */
    public static void split(int i,int beginPos,int actualSize) throws IOException {
        RandomAccessFile random = new RandomAccessFile("D:\\JavaTest\\src\\ShangXueTang300\\JavaIO\\CopyDir.java","r");
        RandomAccessFile random2 = new RandomAccessFile("D:/Sperate/"+i+".txt","rw");//写出流

        random.seek(beginPos);

        byte[] bytes = new byte[actualSize];
        int len = -1;
        while((len = random.read(bytes))!=-1){
            //System.out.println(new String(bytes,0,len));
            if(len<=actualSize){
                //System.out.println(new String(bytes,0,len));
                actualSize -= len;
                random2.write(bytes,0,len);

            }else{
               // System.out.println(new String(bytes,0,actualSize));
                random2.write(bytes,0,actualSize);
                break;
            }
        }

        random.close();
        random2.close();

    }

    public static void test3() throws IOException{
       // File file = new File("D:\\JavaTest\\src\\ShangXueTang300\\JavaIO\\CopyDir.java");
        RandomAccessFile random = new RandomAccessFile("D:\\JavaTest\\src\\ShangXueTang300\\JavaIO\\CopyDir.java","r");
        //List<OutputStream> listFile = new ArrayList<>();

        long fileLen = random.length();

        int beginPos = 0;
        int blockSize = 1024;

        int blockCount = (int)Math.ceil(fileLen*1.0/blockSize); //计算块数，向上取整

        int actualSize = (int)(fileLen>blockSize?blockSize:fileLen); //每块实际大小，若文件长度len小于设定的块大小，则取len
        //计算每块的长度和每块起始位置
        for(int i=0;i<blockCount;i++){
            beginPos = i*blockSize;
            if(i==blockCount-1){
                actualSize = (int)fileLen;
            }else{
                actualSize = blockSize;
                fileLen -= actualSize;
            }
            //计算出位置和长度后，将文件进行分割
            random.seek(beginPos);
            byte[] bytes = new byte[actualSize];
            random.read(bytes);

            String outPath = "D:/Sperate/第"+i+"节.txt";
            OutputStream out = new FileOutputStream(outPath); //新建一个输出流
            out.write(bytes,0,bytes.length);
            out.flush();

            out.close();
           // listFile.add(out);
        }

        random.close();
    }
}

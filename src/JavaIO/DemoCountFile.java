package JavaIO;

import java.io.File;

/**
 * 一个计算文件夹大小和文件个数的程序
 */
public class DemoCountFile {
    private String path;
    private int fileNum;
    private int dirNum;
    private File file;

    public DemoCountFile(String path) {
        this.path = path;
        this.file = new File(path);
        fileLength(this.file);
    }
    private long fileLength=0;

    public int getFileNum() {
        return fileNum;
    }

    public int getDirNum() {
        return dirNum;
    }

    public long getFileLength() {
        return fileLength;
    }

    public void fileLength(File f){
        if(f == null || !f.exists()){
            return;
        }else{
            if(f.isFile()){
                this.fileNum++;
                fileLength += f.length();
            }else{
                this.dirNum++;
                for(File fs:f.listFiles()){
                    fileLength(fs);
                }
            }
        }
    }

    public static void main(String[] args){
        DemoCountFile test = new DemoCountFile("D:/JavaTest/src/ShangXueTang300/images");

        System.out.println("文件大小："+test.getFileLength() +" 文件个数:" +
                test.getFileNum() +" 文件夹个数:" +test.getDirNum());
    }
}

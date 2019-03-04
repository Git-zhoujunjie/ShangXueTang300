package DesignPattern.Composite;

/**
 * 测试组合模式
 * 模拟文件杀毒过程
 */
public class Client {
    public static void main(String[] args) {
        AbstractFile f1,f2,f3,f4;
        f1 = new ImageFile("111.jpg");
        f2 = new TextFile("222.txt");
        f3 = new VideoFile("333.mkv");
        f4 = new VideoFile("555.mkv");

        Folder d1 = new Folder("Study");

        //f1.delete();

        d1.add(f1);
        d1.add(f2);
//        f4.delete();

        Folder d2 = new Folder("Play");
        d2.add(f3);
        d2.add(f4);

        d1.add(d2);
        d1.delete();
    }
}

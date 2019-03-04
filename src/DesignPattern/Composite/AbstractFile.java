package DesignPattern.Composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象组件
 * 用来表示要删除的文件
 */
public interface AbstractFile {
    void delete();
}

class ImageFile implements AbstractFile{
    private String name;
    public ImageFile(String name){
        this.name = name;
    }

    @Override
    public void delete() {
        System.out.println("---图像文件"+name+"：进行查杀！");
    }
}

class TextFile implements AbstractFile{
    private String name;
    public TextFile(String name){
        this.name = name;
    }

    @Override
    public void delete() {
        System.out.println("---文本文件"+name+"：进行查杀！");
    }
}

class VideoFile implements AbstractFile{
    private String name;
    public VideoFile(String name){
        this.name = name;
    }

    @Override
    public void delete() {
        System.out.println("---视频文件"+name+"：进行查杀！");
    }
}

/**
 * 对文件夹进行查杀
 */
class Folder implements AbstractFile{
    private String name;
    private List<AbstractFile> list = new ArrayList<>();

    public Folder(String name){
        this.name = name;
    }

    /*
    包含对文件的增删返回
     */
    public void add(AbstractFile file){
        list.add(file);
    }
    public void remove(AbstractFile file){
        list.remove(file);
    }
    public AbstractFile get(int index){
        return list.get(index);
    }

    /**
     * 删除文件夹时需要遍历数组，包含递归
     */
    @Override
    public void delete() {
        System.out.println("---文件夹"+name+"：进行查杀！");
        for(AbstractFile file : list){
            file.delete();
        }
    }
}

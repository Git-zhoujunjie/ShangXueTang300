package ZJavaAdvanceStage.RegexStudy;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 测试正则表达式的基本用法
 */
public class Demo01 {
    public static void main(String[] args) {
        //字符串：asdgf34frf33，检查字符串是否符合指定的正则表达式
        Pattern p = Pattern.compile("\\w+");
        Matcher m = p.matcher("asdgf34frf33");
        System.out.println(m.matches());

        Matcher m2 = Pattern.compile("\\w+").matcher("asdgf3%4frf33");
        while(m2.find()){ //find表示查找与该模式匹配的下一个子序列
            System.out.println(m2.group());
        }
    }
}

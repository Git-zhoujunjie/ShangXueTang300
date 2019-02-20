package ZJavaAdvanceStage.RegexStudy;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式中的替换操作和分割操作
 */
public class Demo03 {
    public static void main(String[] args) {
//        Matcher m = Pattern.compile("[0-9]").
//                matcher("23aad*asd2*dddd54*gg43243");
//
//        //替换
//        String newStr = m.replaceAll("%");
//        System.out.println(newStr);

        //切割
        String str1 = "a,d,fg";
        System.out.println(Arrays.toString(str1.split(",")));

        String str2 = "sadf5agf67gsfd4fdg4dfasd"; //按数字进行切割
        System.out.println(Arrays.toString(str2.split("\\d+")));
    }
}

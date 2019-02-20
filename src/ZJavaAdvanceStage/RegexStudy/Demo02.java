package ZJavaAdvanceStage.RegexStudy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式中的分组处理
 */
public class Demo02 {
    public static void main(String[] args) {
        Matcher m = Pattern.compile("([a-z]+)([0-9]+)").
                matcher("23aad*asd2*dddd54*gg43243");
        while(m.find()){
            System.out.println(m.group());
//            System.out.println(m.group(1)); //匹配第一个分组([a-z]+)
//            System.out.println(m.group(2));//匹配第二个分组([0-9]+)
        }
    }
}

package ZJavaAdvanceStage.测试脚本引擎Rhino;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Demo01 {
    public static void main(String[] args) throws ScriptException {
        //获取脚本引擎
        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine se = sem.getEngineByName("javascript");

        //定义变量，存储到引擎上下文中
        se.put("msg","1123456543");
        String str = "var list = {name:'laozhou',age:18}";
        str += "println(user,name)";
        //执行脚本
        se.eval(str);
        //更改
        se.eval("msg= '9876543'");
        System.out.println(se.get("msg"));

    }
}

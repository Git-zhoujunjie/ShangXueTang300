package ZJavaAdvanceStage.DynamicCompileStudy;

import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class Demo02 {
    public static void main(String[] args) throws Exception {
        URL[] urls = new URL[]{new URL("")};
        URLClassLoader loader = new URLClassLoader(urls);
        Class c = loader.loadClass("");
        //调用加载类的main方法
        Method m = c.getMethod("main",String[].class);
        m.invoke(null,(Object)new String[]{});
    }
}

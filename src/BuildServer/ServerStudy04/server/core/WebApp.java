package BuildServer.ServerStudy04.server.core;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * 工具类
 * 用于解析配置文件
 * 根据传入的URL根据配置文件创建响应的Servlet并返回
 */
public class WebApp {

    private static WebContext context;
    //静态块
    static {
        try {
            //SAX解析
            //1、获取解析工厂
            SAXParserFactory factory = SAXParserFactory.newInstance();
            //2、从解析工厂中获取解析器
            SAXParser parser = factory.newSAXParser();
            //3、加载文档Document注册处理器
            //4、编写处理器
            WebHandler handle = new WebHandler();
            //5、解析
            parser.parse(Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream("BuildServer/ServerStudy04/web.xml"),handle);

            //获取数据
            context = new WebContext(handle.getEntityList(),handle.getMappingList());

        } catch (Exception e) {
            System.out.println("解析配置文件错误");
        }
    }

    /**
     * 根据URL获取配置文件中响应的Servlet
     * @param url
     * @return
     */
    public static Servlet getServletFromUrl(String url){

        //通过反射从xml文档中解析的字符串创建类的对象
        Class clz = null;
        try {
            clz = Class.forName(context.getClz("/"+url)); //注意这里需要加上“/”
            //采用多态，用接口创建对象
            Servlet servlet = (Servlet) clz.getConstructor().newInstance();

            return servlet;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}

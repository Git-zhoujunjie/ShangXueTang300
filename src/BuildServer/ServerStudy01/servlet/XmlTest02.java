package BuildServer.ServerStudy01.servlet;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 解析web.xml
 */
public class XmlTest02 {

    public static void main(String[] args) throws Exception {
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
        .getResourceAsStream("BuildServer/ServerStudy01/servlet/web.xml"),handle);

        //获取数据
        WebContext context = new WebContext(handle.getEntityList(),handle.getMappingList());

        //通过反射从xml文档中解析的字符串创建类的对象
        Class clz = Class.forName(context.getClz("/g"));

        //采用多态，用接口创建对象
        Servlet servlet = (Servlet) clz.getConstructor().newInstance();
        System.out.println(servlet);
        servlet.service();

    }
}

class WebHandler extends DefaultHandler{

    private List<Entity> entityList = new ArrayList<>();
    private Entity entity;
    private List<Mapping> mappingList = new ArrayList<>();
    private Mapping mapping;

    private String tag;//存储当前的标签
    private boolean _b = true; //true表示解析servlet，false表示解析servlet-mapping

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //只关注qName，表示标签名,，
        //System.out.println(qName+"开始解析");
        //
        if (null != qName) {
            tag = qName;
            if (tag.equals("servlet")) {
                entity = new Entity();
                _b = true;
                // personList.add(person);
            }else if (tag.equals("servlet-mapping")) {
                mapping = new Mapping();
                // personList.add(person);
                _b = false;
            }
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        //处理内容
        String msg = new String(ch, start, length);
        if(_b) {
            if (tag != null) {
                if (tag.equals("servlet-name")) {
                    entity.setName(msg);
                } else if (tag.equals("servlet-class")) {
                    entity.setClz(msg);
                }
            }
        }else{
            if(tag!=null) {
                if (tag.equals("servlet-name")) {
                    mapping.setName(msg);
                } else if (tag.equals("url-pattern")) {
                    mapping.addPattern(msg);
                }
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        //System.out.println(qName + "结束解析");
        //将person存入容器
        if(null!=qName) {
            if (qName.equals("servlet")) {
                //person = new Person();
                entityList.add(entity);
            }else if (qName.equals("servlet-mapping")) {
                mappingList.add(mapping);
            }
        }
        tag = null;
    }

    public List<Entity> getEntityList() {
        return entityList;
    }
    public List<Mapping> getMappingList() {
        return mappingList;
    }
}

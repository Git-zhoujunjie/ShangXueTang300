package BuildServer.ServerStudy01;

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
 * 熟悉XML文件的SAX解析流程
 */
public class XmlTest01 {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        //SAX解析
        //1、获取解析工厂
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //2、从解析工厂中获取解析器
        SAXParser parser = factory.newSAXParser();
        //3、加载文档Document注册处理器
        //4、编写处理器
        PHandle handle = new PHandle();
        //5、解析
        parser.parse(Thread.currentThread().getContextClassLoader()
        .getResourceAsStream("BuildServer/ServerStudy01/p.xml"),handle);

        //获取数据
        List<Person> persons = handle.getPersonList();
        for(Person p:persons){
            System.out.println(p.getName()+"--->"+p.getAge());
        }
    }
}

class PHandle extends DefaultHandler{

    private List<Person> personList;
    private Person person;
    private String tag;//存储当前的标签

    @Override
    public void startDocument() throws SAXException {
        //System.out.println("----解析文档开始----");
        personList = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //只关注qName，表示标签名,，如persons、person、name、age
        //System.out.println(qName+"开始解析");
        //当标签为person时，new一个person对象
        if(null!=qName) {
            tag = qName;
            if (tag.equals("person")) {
                person = new Person();
               // personList.add(person);
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        //处理内容
        String msg = new String(ch, start, length);
        if(tag!=null) {
            if (tag.equals("name")) {
                person.setName(msg);
            } else if (tag.equals("age")) {
                if (msg.length() > 0) {
                    person.setAge(Integer.valueOf(msg));
                }
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        //System.out.println(qName + "结束解析");
        //将person存入容器
        if(null!=qName) {
            if (qName.equals("person")) {
                //person = new Person();
                personList.add(person);
            }
        }
        tag = null;
    }

    @Override
    public void endDocument() throws SAXException {
        //System.out.println("----解析文档结束----");
    }

    public List<Person> getPersonList() {
        return personList;
    }
}

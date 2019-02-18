package BuildServer.ServerStudy03;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

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

package BuildServer.ServerStudy04.server.core;

/**
 * 存储实体信息servlet
 * <servlet>
 *      <servlet-name>login</servlet-name>
 *      <servlet-class>com.shsxt.LoginServlet</servlet-class>
 * </servlet>
 * 一个servlet包含name和class
 */
public class Entity {
    private String name;
    private String clz;

    public Entity() {  //构造器为空即可
    }

    public String getName() {
        return name;
    }

    public String getClz() {
        return clz;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClz(String clz) {
        this.clz = clz;
    }
}

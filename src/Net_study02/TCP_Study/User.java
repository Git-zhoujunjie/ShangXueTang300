package Net_study02.TCP_Study;


/**
 * 封装用户名和密码，实现对象的传输(序列化和反序列化)
 */
public class User implements java.io.Serializable {
    private String uname;
    private String upwd;

    public User(String uname, String upwd) {
        this.uname = uname;
        this.upwd = upwd;
    }

    public String getUname() {
        return uname;
    }

    public String getUpwd() {
        return upwd;
    }
}

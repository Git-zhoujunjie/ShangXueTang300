package BuildServer.ServerStudy03;

public class RegisterServlet implements Servlet {
    @Override
    public void service(Request request,Response response) {
        response.println("注册成功！");
    }
}

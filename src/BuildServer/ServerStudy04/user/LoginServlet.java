package BuildServer.ServerStudy04.user;

import BuildServer.ServerStudy04.server.core.Request;
import BuildServer.ServerStudy04.server.core.Response;
import BuildServer.ServerStudy04.server.core.Servlet;

public class LoginServlet implements Servlet {

    /**
     * 封装服务，根据传入的参数返回响应的内容
     * @param request
     * @param response
     */
    @Override
    public void service(Request request, Response response) {
        response.println("<html>");
        response.println("<head>");
        response.println("<meta http-equiv=\"content-type\" content=\"text/html;charset=utf-8\">");
        response.println("<title>");
        response.println("服务器响应成功");
        response.println("</title>");
        response.println("</head>");
        response.println("<body>");
        response.println("第一个Servlet。。欢迎回来："+request.getValue("uname"));
        response.println("</body>");
        response.println("</html>");
    }
}

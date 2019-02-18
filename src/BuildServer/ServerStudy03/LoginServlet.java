package BuildServer.ServerStudy03;

public class LoginServlet implements Servlet {

    /**
     * 封装服务，根据传入的参数返回响应的内容
     * @param request
     * @param response
     */
    @Override
    public void service(Request request,Response response) {
        response.println("<html>");
        response.println("<head>");
        response.println("<title>");
        response.println("服务器响应成功");
        response.println("</title>");
        response.println("</head>");
        response.println("<body>");
        response.println("第一个Servlet。。");
        response.println("</body>");
        response.println("</html>");
    }
}

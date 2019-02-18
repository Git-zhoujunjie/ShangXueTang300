package BuildServer.ServerStudy04.user;

import BuildServer.ServerStudy04.server.core.Request;
import BuildServer.ServerStudy04.server.core.Response;
import BuildServer.ServerStudy04.server.core.Servlet;

public class RegisterServlet implements Servlet {
    @Override
    public void service(Request request, Response response) {
        //关注业务逻辑
        String uname = request.getValue("uname");
        String[] favs = request.getValues("fav");

        response.println("<html>");
        response.println("<head>");
        response.println("<meta http-equiv=\"content-type\" content=\"text/html;charset=utf-8\">");
        response.println("</head>");
        response.println("<body>");
        response.println("注册信息："+uname);
        response.println("你喜欢的类型：");
        for(String s:favs){
            if(s.equals("0")) response.println("萝莉");
            if(s.equals("1")) response.println("熟女");
            if(s.equals("2")) response.println("傲娇");
        }
        response.println("</body>");
        response.println("</html>");


    }
}

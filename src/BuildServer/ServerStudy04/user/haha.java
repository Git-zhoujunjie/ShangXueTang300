package BuildServer.ServerStudy04.user;

import BuildServer.ServerStudy04.server.core.Request;
import BuildServer.ServerStudy04.server.core.Response;
import BuildServer.ServerStudy04.server.core.Servlet;

public class haha implements Servlet {
    @Override
    public void service(Request request, Response response) {
        response.println("hahahahhaha");
    }
}

package hello.servlet.web.servletmvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "mvcmemberformservlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp"; // WEB-INF 밑에 있는 jsp는 외부에서 호출되지 않음.
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);// controller -> view로 이동할 때 사용함
        dispatcher.forward(request, response); //jsp로 넘어가 호출함, 서버 내부에서 호출되므로 url이 변경되지 않는다. *redirect랑 다름
    }
}

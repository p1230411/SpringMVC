package hello.servlet.web.frontcontroller.v1.controller;

import hello.servlet.web.frontcontroller.v1.ControllerV1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberFormControllerV1 implements ControllerV1 {
    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // MvcMemberFormServlet 내용과 그대로
        String viewPath = "/WEB-INF/views/new-form.jsp"; // WEB-INF 밑에 있는 jsp는 외부에서 호출되지 않음.
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);// controller -> view로 이동할 때 사용함
        dispatcher.forward(request, response); //jsp로 넘어가 호출함, 서버 내부에서 호출되므로 url이 변경되지 않는다. *redirect랑 다름
    }
}

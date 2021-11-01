package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/*
* 1. 파라미터 전송 가능
*   http://localhost:8080/req
* uest-param?username=hello&age=20
*
* */


@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("파라미터 조회 시작");
        request.getParameterNames().asIterator()
                        .forEachRemaining(paramName -> System.out.println(paramName + "=" + request.getParameter(paramName)));

        System.out.println("파라미터 조회 끝");
        System.out.println();

        System.out.println("단일 파라미터 조회");
        String username = request.getParameter("username");
        String age = request.getParameter("age");
        System.out.println("username =" + username + ", age =" + age);
        System.out.println("단일 파라미터 끝");
        System.out.println();

        System.out.println("이름이 같은 복수 파라미터 조회"); //http://localhost:8080/request-param?username=hello&username=hello2 와 같이 username이 어려개인 경우
        String[] usernames = request.getParameterValues("username");
        System.out.println(Arrays.toString(usernames));
        for (String name:usernames) {
            System.out.println("username = " + name);
        }
        System.out.println("복수 파라미터 끝");
        System.out.println();
    }
}


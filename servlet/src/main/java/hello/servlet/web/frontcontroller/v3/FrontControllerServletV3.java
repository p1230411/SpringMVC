package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.ControllerV2;
import hello.servlet.web.frontcontroller.v2.controller.MemberFormContollerV2;
import hello.servlet.web.frontcontroller.v2.controller.MemberListControllerV2;
import hello.servlet.web.frontcontroller.v2.controller.MemberSaveContollerV2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV2", urlPatterns = "/front-controller/v2/*")  // v1 뒤의 모든 url이 들어옴.
public class FrontControllerServletV3 extends HttpServlet {

    private Map<String, ControllerV2> controllerV2Map= new HashMap<>();

    public FrontControllerServletV3() {  // URI 주소를 매핑해놓음.

        controllerV2Map.put("/front-controller/v2/members/new-form", new MemberFormContollerV2());
        controllerV2Map.put("/front-controller/v2/members/save", new MemberSaveContollerV2());
        controllerV2Map.put("/front-controller/v2/members", new MemberListControllerV2());

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI(); // 현재 URI를 가져옴. "/front-controller/v1/members" ... 등
        ControllerV2 controller = controllerV2Map.get(requestURI); // 맵에서 해당 컨트롤러를 꺼내옴

        if(controller == null){ // 컨트롤러가 없으면 404 not found
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        MyView myView = controller.process(request, response);// 있으면 해당 컨트롤러의 process를 호출
        myView.render(request, response);
    }
}

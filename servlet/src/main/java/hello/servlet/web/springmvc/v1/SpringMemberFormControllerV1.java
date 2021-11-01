package hello.servlet.web.springmvc.v1;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // 스프링이 자동으로 스프링 빈으로 등록한다. (내부에 @Component 애노테이션이 있어서 컴포넌트 스캔의 대상이 됨)
public class SpringMemberFormControllerV1 {

    @RequestMapping("/springmvc/v1/member/new-form")
    public ModelAndView process(){
        return new ModelAndView("new-form");

    }
}

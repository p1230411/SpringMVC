package hello.servlet.web.springmvc.v2;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
// @RequestMapping("/springmvc/v2/member")    이렇게도 가능
public class SpringMemberControllerV2 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();


    @RequestMapping("/springmvc/v2/member/new-form")
    public ModelAndView newForm(){
        System.out.println("test");
        return new ModelAndView("new-form");

    }

    @RequestMapping("/springmvc/v2/members")
    public ModelAndView members(Map<String, String> paramMap) {
        List<Member> members = memberRepository.findAll();
        ModelAndView mv = new ModelAndView("members");
//        mv.getModel().put("members", members);  ==> before
        mv.addObject("members",members); // ==> after, view rendering

        return mv;
    }

    @RequestMapping("/springmvc/v2/member/save")
    public ModelAndView save(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        ModelAndView mav = new ModelAndView("save-result");
//        mv.getModel().put("member", member);
        mav.addObject("member",member);
        return mav;
    }
}

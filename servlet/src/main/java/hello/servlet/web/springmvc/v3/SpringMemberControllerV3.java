package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/springmvc/v3/member")
public class SpringMemberControllerV3 {
    private final MemberRepository memberRepository = MemberRepository.getInstance();


//    @RequestMapping(value = "/new-form", method = RequestMethod.GET)
    @GetMapping("/new-form") // 위의 코드를 이렇게 줄여서 사용
    public String newForm(){  // String 으로
        return "new-form";
//        return new ModelAndView("new-form");

    }

//    @RequestMapping(value = "/members", method = RequestMethod.GET)
    @GetMapping("/members")
    public String members(Model model) { // String 으로
        List<Member> members = memberRepository.findAll();
//        ModelAndView mv = new ModelAndView("members");
//        mv.getModel().put("members", members);
        model.addAttribute("members", members);

        return "members";
    }

//    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @PostMapping("/save")
    public String save(     // String 으로 !
            @RequestParam("username") String username,
            @RequestParam("age") int age,   // request에서 따로 받을필요 없고, 형변환도 자동으로 해줌.
            Model model) {
//        String username = request.getParameter("username");
//        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

//        ModelAndView mav = new ModelAndView("save-result");
//        mv.getModel().put("member", member);
//        mav.addObject("member",member);
        model.addAttribute("member",member);
        return "save-result";
    }
}

package mvcre.hello.servlet.web.springmvc.v1;

import mvcre.hello.servlet.domain.member.Member;
import mvcre.hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SpringMemberListControllerV1 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/springmvc/v1/members")
    public ModelAndView process() {
        final List<Member> members = memberRepository.findAll();
        final ModelAndView mv = new ModelAndView("members");
        mv.addObject("members", members);
        return mv;
    }
}

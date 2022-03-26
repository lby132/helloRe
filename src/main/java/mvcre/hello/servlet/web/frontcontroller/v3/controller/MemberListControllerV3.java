package mvcre.hello.servlet.web.frontcontroller.v3.controller;

import mvcre.hello.servlet.domain.member.Member;
import mvcre.hello.servlet.domain.member.MemberRepository;
import mvcre.hello.servlet.web.frontcontroller.ModelView;
import mvcre.hello.servlet.web.frontcontroller.v3.ControllerV3;

import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        final List<Member> members = memberRepository.findAll();
        final ModelView mv = new ModelView("members");
        mv.getModel().put("members", members);
        return mv;
    }
}

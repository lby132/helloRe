package mvcre.hello.servlet.web.frontcontroller.v3.controller;

import mvcre.hello.servlet.domain.member.Member;
import mvcre.hello.servlet.domain.member.MemberRepository;
import mvcre.hello.servlet.web.frontcontroller.ModelView;
import mvcre.hello.servlet.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        final String username = paramMap.get("username");
        final int age = Integer.parseInt(paramMap.get("age"));

        final Member member = new Member(username, age);
        memberRepository.save(member);

        return new ModelView("save-result");
    }
}

package com.example.hellospring.controller;

import com.example.hellospring.domain.Member;
import com.example.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService; // 필드 주입을 통한 DI

//    @Autowired
//    public void setMemberService(MemberService memberService) {  // setter DI
//        this.memberService = memberService;
//    }

    @Autowired
    public MemberController(MemberService memberService) {  // 생성자 주입 방식을 통한 DI 권장
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {

        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("members")
    public String list(Model model){
        List<Member> members = memberService.findMemebrs();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}

package com.example.hellospring.controller;

import com.example.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    @Autowired private MemberService memberService; // 필드 주입을 통한 DI

//    @Autowired
//    public void setMemberService(MemberService memberService) {  // setter DI
//        this.memberService = memberService;
//    }

    @Autowired
    public MemberController(MemberService memberService) {  // 생성자 주입 방식을 통한 DI 권장
        this.memberService = memberService;
    }
}

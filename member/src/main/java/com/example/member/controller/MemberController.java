package com.example.member.controller;

import com.example.member.dto.MemberDto;
import com.example.member.mappers.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    MemberMapper memberMapper;

    @GetMapping("")
    public String getMemberList(Model model, @RequestParam(defaultValue = "") String searchType, @RequestParam(defaultValue = "") String words) {
        String queryString = "";
        if( searchType.equals("userid") ){
            queryString = "WHERE userid = '"+words+"'";
        }else if( searchType.equals("username") ) {
            queryString = "WHERE username = '"+words+"'";
        }else{
//            select * from member

            queryString = "";
        }
        System.out.println(queryString);

        model.addAttribute("cnt", memberMapper.getMemberCount(queryString));
        model.addAttribute("mem", memberMapper.getMemberList(queryString));
        return "member/list";
    }
    @GetMapping("/insert")
    public String getInsert() {
        return "member/insert";
    }
    @PostMapping("/insert")
    public String setInsert(@ModelAttribute MemberDto memberDto, RedirectAttributes ra) {
        memberMapper.setInsert(memberDto);
        //post 타입 : 주소에 드러나지 않음
        //model.attribute -> get 방식
        ra.addFlashAttribute("message", "회원가입 완료되었습니다.");
        return "redirect:/member";
    }
    @GetMapping("/delete")
    public String deleteMember(@RequestParam int id, RedirectAttributes ra) {
        memberMapper.deleteMember(id);
        ra.addFlashAttribute("message", "회원이 삭제되었습니다.");
        return "redirect:/member";
    }
    @GetMapping("/view")
    public String viewMember(@RequestParam int id, Model model) {
        model.addAttribute("mem",memberMapper.viewMember(id));
        return "member/view";
    }
    @GetMapping("/update")
    public String getUpdate(@RequestParam int id, Model model) {
        model.addAttribute("view", memberMapper.viewMember(id));

        return "member/update";
    }
    @PostMapping("/update")
    public String setUpdate(@ModelAttribute MemberDto memberDto, RedirectAttributes ra) {
        memberMapper.setUpdate(memberDto);
        ra.addFlashAttribute("message", "회원정보가 수정되었습니다.");
        return "redirect:/member";
    }
}

package com.example.tut02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("/users")
public class UsersController {

    //login
    @GetMapping("/login")
    public String getLogin () {
        return "users/login";
    }

    //register
    @GetMapping("/register")
    public String getRegister () {
        return "users/register";
    }

    //ajax -> data처리 -> responseBody
    @GetMapping("/getAjax")
    @ResponseBody //html을 띄우는게 아니면  responseBody
    public Map<String, Object> getAjax() {
        //List(순서가있는배열), Map(키, 값) => 동적배열
        Map<String, Object> map = new HashMap<>(); //object = json
        map.put("userid", "koreait"); //map.put   list.add
        map.put("passwd", "1234");

        return map;
    }
    @PostMapping("/setAjax")
    @ResponseBody
    public Map<String, Object> setAjax(@RequestParam String userid, @RequestParam String passwd) {
        System.out.println(userid);
        System.out.println(passwd);
        Map<String, Object> map = new HashMap<>();
        if( userid != null ) {
            map.put("msg", "성공적으로 데이터가 전송되었습니다.");
        }
        return map;
    }

}

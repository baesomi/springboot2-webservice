package com.baesomi.project.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// JSON을 반환하는 컨트롤러로 만들어주는 annotation
@RestController
public class HelloController {
    // HTTP Method인 Get의 요청을 받을 수 있는 API를 만들어준다 (구:@RequestMapping)
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
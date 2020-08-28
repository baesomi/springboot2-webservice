package com.baesomi.project.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/*
* 1. RunWith : 스프링부트 테스트와 JUnit 사이의 연결자 역할
* 2. WebMvcTest : 여러 스프링 테스트 어노테이션 중, WEB에 집중할 수 있는 어노테이션
* 3. AutoWired : 스프링이 관리하는 Bean을 주입받는다.
* 4. private MockMvc mvc : 웹 API를 테스트할 때 사용 / HTTP GET,POST등에 대한 API테스트를 할 수 있다.
* */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void hello_return() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));

    }
    //jsonPath : json 응답값을 필드별로 검증할 수 있는 메소드. $ 기준으로 필드명 명시
    @Test
    public void helloDto_return() throws Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                    get("/hello/dto")
                .param("name", name)
                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));

    }
}


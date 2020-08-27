package com.baesomi.project.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Class
 * SpringBootApplication 으로 인해 스프링 부트의 자동설정, 스프링 빈 읽기와 생성을 모두 자동으로함.
 * 특히 정의된 위치부터 설정을 읽어가기 때문에 이 클래스는 항상 프로젝트 최상단에 위치해야함
 */

@SpringBootApplication
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}

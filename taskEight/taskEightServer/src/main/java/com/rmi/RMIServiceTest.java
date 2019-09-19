package com.rmi;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RMIServiceTest {

    public static void main(String[] args) {

        new ClassPathXmlApplicationContext("classpath:spring/spring-mybatis.xml");

    }

}
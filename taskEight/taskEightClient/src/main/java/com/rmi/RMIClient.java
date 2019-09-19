package com.rmi;


import com.service.ExcellentsStudentService;
import com.service.ProfessionService;
import com.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RMIClient {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("rmiClient.xml");
        ExcellentsStudentService es = applicationContext.getBean("myRMIClient", ExcellentsStudentService.class);
        ProfessionService professionService = applicationContext.getBean("proClient", ProfessionService.class);
        UserService userService = applicationContext.getBean("userClient", UserService.class);
        System.out.println(es.getAdd(324, 4));
    }

}
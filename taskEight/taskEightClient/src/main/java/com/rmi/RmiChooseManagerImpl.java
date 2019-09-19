package com.rmi;

import com.controller.UserHandler;
import com.service.ExcellentsStudentService;
import com.service.ProfessionService;
import com.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RmiChooseManagerImpl implements RmiChooseManager {

    private static final Logger logger = Logger.getLogger(RmiChooseManagerImpl.class);
    @Qualifier("myRMIClient")
    @Autowired
    ExcellentsStudentService excellentsStudentService;

    @Qualifier("proClient")
    @Autowired
    ProfessionService professionService;

    @Qualifier("userClient")
    @Autowired
    UserService userService;


    //扩展后的webService
    @Qualifier("myRMIClient2")
    @Autowired
    ExcellentsStudentService excellentsStudentService2;

    @Qualifier("proClient2")
    @Autowired
    ProfessionService professionService2;

    @Qualifier("userClient2")
    @Autowired
    UserService userService2;


    @Override
    public ExcellentsStudentService chooseExcellentsStudentService() {
        logger.info("--------------原来的12----------------");
        return (ExcellentsStudentService) chooseServer(excellentsStudentService, excellentsStudentService2);
    }

    @Override
    public ProfessionService chooseProfessionService() {
        logger.info("-----------原来的34-----------");
        return (ProfessionService) chooseServer(professionService, professionService2);
    }

    @Override
    public UserService chooseUserService() {
        logger.info("------------原来的56-------------");
        return (UserService) chooseServer(userService, userService2);
    }


    private Object chooseServer(Object m1, Object m2) {
        int choose = new Random().nextInt(2);
        if (0 == choose) {
            try {

                return m1;
            } catch (Exception e1) {
                try {

                    return m2;
                } catch (Exception e2) {

                }
            }
        }
        if (1 == choose) {


            return m2;
        }

        return m1;

    }


}

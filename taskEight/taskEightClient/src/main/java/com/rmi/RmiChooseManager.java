package com.rmi;

import com.service.ExcellentsStudentService;
import com.service.ProfessionService;
import com.service.UserService;
import org.springframework.stereotype.Component;


@Component
public interface RmiChooseManager {
    ExcellentsStudentService chooseExcellentsStudentService();

    ProfessionService chooseProfessionService();

    UserService chooseUserService();
}

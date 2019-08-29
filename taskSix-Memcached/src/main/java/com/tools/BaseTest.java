package com.tools;


import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Log4jConfigurer;

import java.io.FileNotFoundException;

/**
 * @author guangyin
 */
@RunWith(SpringJUnit4ClassRunner.class)
/*
 * @TransactionConfiguration(transactionManager = "transactionManager")
 *
 * @Transactional
 */
@ContextConfiguration("classpath:spring/app-context-xmemcached.xml")
public class BaseTest {
    /**
     * 添加字段注释.
     */
    protected Logger logger = Logger.getLogger(BaseTest.class);
    static {
        try {
            Log4jConfigurer.initLogging("log4j.properties");
        } catch (FileNotFoundException ex) {
            System.err.println("Cannot Initialize log4j");
        }
    }

}
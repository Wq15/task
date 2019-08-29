package tools;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tools.RedisUtil;

class TestRedis {

    public static void main(String[] args) throws Exception {
        @SuppressWarnings("resource")
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        RedisUtil redisUtil=(RedisUtil) context.getBean("redisUtil");

        //=====================testString======================
        redisUtil.set("name", "王赛超");
        redisUtil.set("age", 24);
        redisUtil.set("address", "河北邯郸");

        System.out.println(redisUtil.set("address", "河北邯郸", 50));

        System.out.println(redisUtil.get("address"));


    }



}

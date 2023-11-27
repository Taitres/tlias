package com.taitres;

import com.taitres.controller.DeptController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class TliasApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testUuid() {
        for (int i = 0; i < 10; i++){
            System.out.println("uuid = " + java.util.UUID.randomUUID().toString());
        }

    }

    @Autowired
    private ApplicationContext applicationContext; //ioc容器对象

    @Test
    public void testIoc() {

        DeptController bean1 = (DeptController) applicationContext.getBean("deptController");
        System.out.println(bean1);

        DeptController bean2 = applicationContext.getBean(DeptController.class);
        System.out.println(bean2);

        DeptController bean3 = applicationContext.getBean("deptController", DeptController.class);
        System.out.println(bean3);

    }


}

package com.taitres;

import com.taitres.controller.DeptController;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
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


    //第三方bean的管理
    @Autowired
    private SAXReader saxReader;
    @Test
    public void testThirdBean() throws Exception {


        Document document = saxReader.read(this.getClass().getClassLoader().getResource("1.xml"));
        Element rootElement = document.getRootElement();
        String name = rootElement.element("name").getText();
        String age = rootElement.element("age").getText();

        System.out.println(name + " : " + age);
    }


}

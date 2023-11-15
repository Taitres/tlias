package com.taitres;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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

}

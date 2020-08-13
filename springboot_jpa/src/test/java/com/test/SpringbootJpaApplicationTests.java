package com.test;

import com.test.enums.HTMLPageEnum;
import com.test.service.IStuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootJpaApplicationTests {
    private Logger logger = LoggerFactory.getLogger(SpringbootJpaApplicationTests.class);
    @Test
    public void contextLoads() {
    }

    @Autowired
    private IStuService iStuService;
    @Test
    public void enumTest(){
        HTMLPageEnum.getList();
        logger.info("枚举集合：{}",HTMLPageEnum.getList().toString());
    }
    @Test
    public void stuTest(){
        iStuService.findByName("张三");
    }
}

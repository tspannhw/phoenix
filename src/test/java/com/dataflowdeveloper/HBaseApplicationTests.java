package com.dataflowdeveloper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HBaseApplicationTests {
	Logger logger = LoggerFactory.getLogger(HBaseApplicationTests.class);

	@Test
	public void contextLoads() {
		logger.error("Started");
	}

}

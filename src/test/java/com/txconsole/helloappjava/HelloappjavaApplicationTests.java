package com.txconsole.helloappjava;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.txconsole.helloappjava.controllers.ApiController;

@SpringBootTest
class HelloappjavaApplicationTests {

	@Autowired
	private ApiController controller;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}

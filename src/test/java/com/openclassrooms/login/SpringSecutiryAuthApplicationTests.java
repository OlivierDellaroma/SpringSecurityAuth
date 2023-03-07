package com.openclassrooms.login;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.openclassrooms.controller.LoginController;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class SpringSecutiryAuthApplicationTests {

	@Autowired
	private LoginController controller;
	
	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}

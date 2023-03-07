package com.openclassrooms.login;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SpringWebAppTests {

	@Autowired
	private MockMvc mock;
	
	@Autowired
	private WebApplicationContext context;
	
	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		mock.perform(get("/login")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void userLoginTest() throws Exception {
		mock.perform(formLogin("/login").user("springuser").password("spring123")).andExpect(authenticated());
	}
	
	@Test
	public void userLoginFail() throws Exception {
		mock.perform(formLogin("/login").user("springuser").password("passwordfail")).andExpect(unauthenticated());
	}
	
	@BeforeEach
	public void setup() {
		mock = MockMvcBuilders
				.webAppContextSetup(context)
				.apply(springSecurity())
				.build();
		
	}
	
}

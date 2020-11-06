package com.test;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

//SpringJunit4Ruinner
//SpringRunner-->Junit5
//@RunWith(SpringRunner.class) // Junit 5
@ExtendWith(SpringExtension.class)//Junit 5
@SpringBootTest // Testcase inside Spring Boot
@ContextConfiguration(classes = TestBeanConfig.class) // componentscan
public class LoginControllerTest {
	@Autowired
	WebApplicationContext context;
	private MockMvc mvc;

	@BeforeEach
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void loginTest() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/login")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.view().name("login"));
	}

	@Test
	public void registerTest() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/register")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.view().name("register"));
	}

	@Test
	public void successTest() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/success")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.view().name("success"));
	}

	@Test
	public void welcomeTest() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/welcome")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.view().name("welcome"));
	}

}

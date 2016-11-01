package com.algo.done;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AlgoApplication.class)
@WebAppConfiguration
public class AlgoApplicationTests  extends BaseIntegrationTest{
	
	 private MockMvc mockMvc;
	 
	 @Autowired
	 private WebApplicationContext webApplicationContext;
	 
	 @Before
	 public void setup() throws Exception {
	 this.mockMvc = webAppContextSetup(webApplicationContext).build();
       }
	
		@Test
		public void contextLoads() {
		}
		
		
		@Test
		public void getItemsShouldReturnBothItems() throws Exception {
			this.mockMvc.perform(get("/100"))				
					.andExpect(content().string("Maximum satisfaction that can be attained by Mr. Gorden in 100 is :168349"));
		}

}

package com.tw.apistackbase;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApiStackBaseApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void should_return_companies_when_call_get_all_companies() throws Exception {
		mockMvc.perform(get("/companies"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(content().json("[\n" +
						"\t{\n" +
						"\t\t\"companyName\": \"alibaba\",\n" +
						"\t\t\"employeesNumber\": 1,\n" +
						"\t\t\"employees\": [\n" +
						"\t\t\t{\n" +
						"\t\t\t\t\"id\": 4,\n" +
						"\t\t\t\t\"name\": \"alibaba1\",\n" +
						"\t\t\t\t\"age\": 20,\n" +
						"\t\t\t\t\"gender\": \"male\",\n" +
						"\t\t\t\t\"salary\": 6000\n" +
						"\t\t\t}\n" +
						"\t\t]\n" +
						"\t}\n" +
						"]"));
	}

}

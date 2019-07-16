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
						"    {\n" +
						"        \"companyName\": \"alibaba\",\n" +
						"        \"employeesNumber\": 1,\n" +
						"        \"employees\": [\n" +
						"            {\n" +
						"                \"id\": 4,\n" +
						"                \"name\": \"alibaba1\",\n" +
						"                \"age\": 20,\n" +
						"                \"gender\": \"male\",\n" +
						"                \"salary\": 6000\n" +
						"            }\n" +
						"        ]\n" +
						"    },\n" +
						"    {\n" +
						"        \"companyName\": \"1\",\n" +
						"        \"employeesNumber\": 1,\n" +
						"        \"employees\": [\n" +
						"            {\n" +
						"                \"id\": 4,\n" +
						"                \"name\": \"alibaba1\",\n" +
						"                \"age\": 20,\n" +
						"                \"gender\": \"male\",\n" +
						"                \"salary\": 6000\n" +
						"            }\n" +
						"        ]\n" +
						"    }\n" +
						"]"));
	}

	@Test
	public void should_return_company_when_call_find_company_by_id_given_company_id() throws Exception {
		mockMvc.perform(get("/companies/1"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(content().json("{\n" +
						"    \"companyName\": \"1\",\n" +
						"    \"employeesNumber\": 1,\n" +
						"    \"employees\": [\n" +
						"        {\n" +
						"            \"id\": 4,\n" +
						"            \"name\": \"alibaba1\",\n" +
						"            \"age\": 20,\n" +
						"            \"gender\": \"male\",\n" +
						"            \"salary\": 6000\n" +
						"        }\n" +
						"    ]\n" +
						"}"));
	}

	@Test
	public void should_return_employees_when_call_find_company_by_name_given_company_name() throws Exception {
		mockMvc.perform(get("/companies/1/employees"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(content().json("[\n" +
						"    {\n" +
						"        \"id\": 4,\n" +
						"        \"name\": \"alibaba1\",\n" +
						"        \"age\": 20,\n" +
						"        \"gender\": \"male\",\n" +
						"        \"salary\": 6000\n" +
						"    }\n" +
						"]"));
	}

	@Test
	public void should_return_limit_companies_when_call_get_companies_by_page_and_size_given_1_5() throws Exception {
		mockMvc.perform(get("/companies?page=1&pageSize=5"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(content().json("[\n" +
						"    {\n" +
						"        \"companyName\": \"alibaba\",\n" +
						"        \"employeesNumber\": 1,\n" +
						"        \"employees\": [\n" +
						"            {\n" +
						"                \"id\": 4,\n" +
						"                \"name\": \"alibaba1\",\n" +
						"                \"age\": 20,\n" +
						"                \"gender\": \"male\",\n" +
						"                \"salary\": 6000\n" +
						"            }\n" +
						"        ]\n" +
						"    },\n" +
						"    {\n" +
						"        \"companyName\": \"1\",\n" +
						"        \"employeesNumber\": 1,\n" +
						"        \"employees\": [\n" +
						"            {\n" +
						"                \"id\": 4,\n" +
						"                \"name\": \"alibaba1\",\n" +
						"                \"age\": 20,\n" +
						"                \"gender\": \"male\",\n" +
						"                \"salary\": 6000\n" +
						"            }\n" +
						"        ]\n" +
						"    }\n" +
						"]"));
	}

}

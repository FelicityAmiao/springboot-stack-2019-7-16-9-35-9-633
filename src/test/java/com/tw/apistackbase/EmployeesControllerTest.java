package com.tw.apistackbase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class EmployeesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_return_employees_when_call_get_all_employees() throws Exception {
        mockMvc.perform(get("/employees"))
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
    public void should_return_employee_when_call_get_one_specify_employee_1() throws Exception {
        mockMvc.perform(get("/employees/4"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json("{\n" +
                        "    \"id\": 4,\n" +
                        "    \"name\": \"alibaba1\",\n" +
                        "    \"age\": 20,\n" +
                        "    \"gender\": \"male\",\n" +
                        "    \"salary\": 6000\n" +
                        "}"));
    }

    @Test
    public void should_return_limit_employees_when_call_get_employees_by_page_and_size_given_1_5() throws Exception {
        mockMvc.perform(get("/employees?page=1&pageSize=5"))
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
    public void should_return_specify_gender_employees_when_call_get_employees_by_gender_given_male() throws Exception {
        mockMvc.perform(get("/employees?gender=male"))
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
    public void should_return_employees_when_call_add_employees_given_employee() throws Exception {
        mockMvc.perform(post("/employees").contentType("application/json;charset=UTF-8").content("{\n" +
                "    \"id\": 2,\n" +
                "    \"name\": \"alimama\",\n" +
                "    \"age\": 33,\n" +
                "    \"gender\": \"female\",\n" +
                "    \"salary\": 6000\n" +
                "}"))
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
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 2,\n" +
                        "        \"name\": \"alimama\",\n" +
                        "        \"age\": 33,\n" +
                        "        \"gender\": \"female\",\n" +
                        "        \"salary\": 6000\n" +
                        "    }\n" +
                        "]"));
    }

    @Test
    public void should_return_employees_when_call_modify_employees_given_0_employee() throws Exception {
        mockMvc.perform(put("/employees/0").contentType("application/json;charset=UTF-8").content("{\n" +
                "    \"id\": 3,\n" +
                "    \"name\": \"alimama\",\n" +
                "    \"age\": 33,\n" +
                "    \"gender\": \"female\",\n" +
                "    \"salary\": 6000\n" +
                "}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json("[\n" +
                        "    {\n" +
                        "        \"id\": 3,\n" +
                        "        \"name\": \"alimama\",\n" +
                        "        \"age\": 33,\n" +
                        "        \"gender\": \"female\",\n" +
                        "        \"salary\": 6000\n" +
                        "    }\n" +
                        "]"));
    }
}
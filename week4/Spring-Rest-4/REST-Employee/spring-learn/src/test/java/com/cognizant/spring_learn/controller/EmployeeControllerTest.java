package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Test
    void testInvalidEmployeeIdFormat() throws Exception {
        String invalidJson = """
            {
              "id": "abc",
              "name": "Test User",
              "salary": 60000,
              "permanent": true,
              "dateOfBirth": "15/08/1990",
              "department": { "id": 101, "name": "HR" },
              "skills": [{ "id": 201, "name": "Java" }]
            }
            """;

       MvcResult result = mockMvc.perform(put("/employees")
        .contentType(MediaType.APPLICATION_JSON)
        .content(invalidJson))
        .andExpect(status().isBadRequest())
        .andReturn();

System.out.println("RESPONSE JSON:\n" + result.getResponse().getContentAsString());
    }
}
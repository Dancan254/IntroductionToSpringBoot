package com.Practise.Introduction.Controller;

import com.Practise.Introduction.Entity.Department;
import com.Practise.Introduction.Service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DepartmentService departmentService;

    Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentName("Mechanical")
                .departmentAddress("SOE")
                .departmentCode("E023")
                .id(1L)
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment = Department.builder()
                .departmentName("Mechanical")
                .departmentAddress("SOE")
                .departmentCode("E023")
                .id(1L)
                .build();
        Mockito.when(departmentService.saveDepartment(inputDepartment))
                .thenReturn(department);
        //call endpoint
        mockMvc.perform(post("/departments")
                        .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "        \"id\": 1,\n" +
                        "        \"departmentName\": \"mechatronics\",\n" +
                        "        \"departmentAddress\": \"E024_MECH\",\n" +
                        "        \"departmentCode\": \"E024\"\n" +
                        "    }"))
                .andExpect(status().isOk());
    }

    @Test
    void fetchDepartmentById() throws Exception{
        Mockito.when(departmentService.fetchDepartmentById(1L))
                .thenReturn(department);
        mockMvc.perform(get("/departments/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departmentName")
                        .value(department.getDepartmentName()));
    }
}
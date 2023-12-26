package com.Practise.Introduction.service;

import com.Practise.Introduction.Entity.Department;
import com.Practise.Introduction.Repository.DepartmentRepository;
import com.Practise.Introduction.Service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {
    @Autowired
    DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;
    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("mech")
                .departmentAddress("E023-mech")
                .departmentCode("E023")
                .id(1L)
                .build();
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("mech"))
                .thenReturn(department);
    }

    @Test
    @DisplayName("Get data based on Valid Department Name")
    public void whenValidDepartmentNameDepartmentFound(){
            String departmentName = "mech";
        Department found = departmentService.getDepartmentByName(departmentName);
        assertEquals(departmentName, found.getDepartmentName());
    }
}
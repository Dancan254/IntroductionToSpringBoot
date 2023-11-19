package com.Practise.Introduction.Controller;

import com.Practise.Introduction.Entity.Department;
import com.Practise.Introduction.Service.DepartmentService;
import com.Practise.Introduction.error.DepartmentNotFound;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    // Endpoint to save a new department
    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        logger.info("Inside save department of Department Controller");
        return departmentService.saveDepartment(department);
    }

    // Endpoint to fetch the list of all departments
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        logger.info("Inside fetch department list of Department Controller");
        return departmentService.fetchDepartmentList();
    }

    // Endpoint to fetch a department by its ID
    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFound {
        return departmentService.fetchDepartmentById(departmentId);
    }

    // Endpoint to delete a department by its ID
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted successfully";
    }

    // Endpoint to update a department by its ID
    @PutMapping("departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody Department department){
        return departmentService.updateDepartment(departmentId, department);
    }

    // Endpoint to get a department by its name
    @GetMapping("/departments/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.getDepartmentByName(departmentName);
    }
}

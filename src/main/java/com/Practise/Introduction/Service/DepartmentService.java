package com.Practise.Introduction.Service;

import com.Practise.Introduction.Entity.Department;
import com.Practise.Introduction.error.DepartmentNotFound;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);
   List<Department> fetchDepartmentList();
   Department fetchDepartmentById(Long departmentId) throws DepartmentNotFound;
    void deleteDepartmentById(Long departmentId);
    Department updateDepartment(Long departmentId, Department department);
    Department getDepartmentByName(String departmentName);
}

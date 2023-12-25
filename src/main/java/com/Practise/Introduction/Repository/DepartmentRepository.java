package com.Practise.Introduction.Repository;

import com.Practise.Introduction.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByDepartmentNameIgnoreCase(String departmentName);

}

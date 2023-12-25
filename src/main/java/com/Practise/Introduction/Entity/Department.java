package com.Practise.Introduction.Entity;

import com.Practise.Introduction.Controller.DepartmentController;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    //validations
//    @Length(max = 10, min = 3)
//    @Size(max= 10, min = 5)
//    @Email
//    @Positive
//    @Negative
    @NotBlank(message = "Please add a department name") //ensures that no blank name is passed
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;

}

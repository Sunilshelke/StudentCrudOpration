package com.example.StudentInfo.DTO.requestDTO;

import com.example.StudentInfo.enums.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class StudentRequestDto
{
    private String name;

    private int age;

    private Department department;

    private String mobNo;
}

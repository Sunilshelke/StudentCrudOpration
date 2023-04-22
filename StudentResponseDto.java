package com.example.StudentInfo.DTO.responseDTO;

import com.example.StudentInfo.enums.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class StudentResponseDto
{
    private int id;

    private String name;

    private int age;

    private Department department;

    private String mobNo;
}

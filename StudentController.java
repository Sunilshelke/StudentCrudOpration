package com.example.StudentInfo.controller;

import com.example.StudentInfo.DTO.requestDTO.StudentRequestDto;
import com.example.StudentInfo.DTO.requestDTO.UpdateStudentMobRequestDto;
import com.example.StudentInfo.DTO.responseDTO.StudentResponseDto;
import com.example.StudentInfo.DTO.responseDTO.UpdateStudentMobNoResponseDto;
import com.example.StudentInfo.exeption.StudentNotFoundException;
import com.example.StudentInfo.service.StudentService;
import com.example.StudentInfo.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController
{
    @Autowired
    StudentService studentService;

        @PostMapping("/add")
        public String addStudent(@RequestBody StudentRequestDto studentRequestDto){

        return studentService.addStudent(studentRequestDto);
    }

    @GetMapping("/get_student")
    public StudentResponseDto getStudent(@RequestParam("id") int id)
    {
        return studentService.getStudentByID(id);
    }
    @PutMapping("/update_mobile")
    public UpdateStudentMobNoResponseDto updateMobNo(@RequestBody UpdateStudentMobRequestDto updateStudentMobRequestDto ) throws StudentNotFoundException {


        return studentService.updateMobNo(updateStudentMobRequestDto);
    }
    @DeleteMapping("/delet_student")
    public String deleteStudentById(@RequestParam int id)
    {
        studentService.deleteStudentByid(id);
        return "Student Deleted";
    }
}

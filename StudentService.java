package com.example.StudentInfo.service;

import com.example.StudentInfo.DTO.requestDTO.StudentRequestDto;
import com.example.StudentInfo.DTO.requestDTO.UpdateStudentMobRequestDto;
import com.example.StudentInfo.DTO.responseDTO.StudentResponseDto;
import com.example.StudentInfo.DTO.responseDTO.UpdateStudentMobNoResponseDto;
import com.example.StudentInfo.exeption.StudentNotFoundException;
import com.example.StudentInfo.repository.StudentRepository;
import com.example.StudentInfo.student.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Service
public class StudentService
{
    @Autowired
    StudentRepository studentRepository;


    public String addStudent(StudentRequestDto studentRequestDto)
    {
        Student student=new Student();
        student.setAge(studentRequestDto.getAge());
        student.setName(studentRequestDto.getName());
        student.setDepartment(studentRequestDto.getDepartment());
        student.setMobNo(studentRequestDto.getMobNo());

        studentRepository.save(student);
        return  "Student added";
    }

    public StudentResponseDto getStudentByID(int id)
    {

        Student student= studentRepository.findById(id).get();
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setId(student.getId());
        studentResponseDto.setName(student.getName());
        studentResponseDto.setDepartment(student.getDepartment());
        studentResponseDto.setAge(student.getAge());
        studentResponseDto.setMobNo(student.getMobNo());
        return  studentResponseDto;
    }

    public UpdateStudentMobNoResponseDto updateMobNo(UpdateStudentMobRequestDto updateStudentMobRequestDto) throws StudentNotFoundException {

        try{
            Student student = studentRepository.findById(updateStudentMobRequestDto.getId()).get();
            student.setMobNo(updateStudentMobRequestDto.getMobNo());
            Student updatedStudent = studentRepository.save(student);

            // prepare response dto
            UpdateStudentMobNoResponseDto updateStudentMobNoResponseDto = new UpdateStudentMobNoResponseDto();
            updateStudentMobNoResponseDto.setName(updatedStudent.getName());
            updateStudentMobNoResponseDto.setMobNo(updateStudentMobRequestDto.getMobNo());
            return updateStudentMobNoResponseDto;
        }
        catch (Exception e){
            throw new StudentNotFoundException("Invalid student id");
        }
    }

    public String deleteStudentByid(int id)
    {
        studentRepository.deleteById(id);
        return "Student Sucessfully Deleted";
    }

}


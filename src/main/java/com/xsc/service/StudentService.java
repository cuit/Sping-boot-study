package com.xsc.service;

import com.xsc.enums.ResultEnum;
import com.xsc.exception.StudentException;
import com.xsc.model.Student;
import com.xsc.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by XSC on 2017/5/5.
 */
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    public void age(Integer id){
        Student student = studentRepository.findOne(id);
        Integer age = student.getAge();
        if(age < 15){
            throw new StudentException(ResultEnum.PRIMARY_STUDENT);
        }else if (age >= 15 && age <= 18 ){
            throw new StudentException(ResultEnum.MIDDLE_STUDENT);
        }
    }
}

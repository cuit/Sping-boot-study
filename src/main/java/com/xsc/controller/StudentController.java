package com.xsc.controller;

import com.xsc.model.Result;
import com.xsc.model.Student;
import com.xsc.service.StudentService;
import com.xsc.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by XSC on 2017/5/5.
 */
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/students",method = RequestMethod.GET)
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @RequestMapping(value = "/students",method = RequestMethod.POST)
    public Result<Student> addStudent(@Valid Student student, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultUtil.fail(100,bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success("学生添加成功！",studentService.addStudent(student));
    }

    @RequestMapping(value = "/students/age/{id}",method = RequestMethod.GET)
    public void age(@PathVariable("id") Integer id){
        studentService.age(id);
    }
}

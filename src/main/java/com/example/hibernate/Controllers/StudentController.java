package com.example.hibernate.Controllers;

import com.example.hibernate.Model.Student;
import com.example.hibernate.Services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(path="/student")
public class StudentController {

    private final StudentServices studentServices;

    @Autowired
    public StudentController(StudentServices studentServices){
        this.studentServices=studentServices;
    }

    @GetMapping("/get")
    public List<Student> getStudent(){

        return studentServices.getStudents();
    }

}

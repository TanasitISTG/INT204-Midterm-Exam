package com.example.demo.Controllers;

import com.example.demo.Entities.Student;
import com.example.demo.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/init")
    public List<Student> init() {
        studentService.saveAll(List.of(
                new Student(1, "John", 3.5),
                new Student(2, "Jane", 3.8),
                new Student(3, "Max", 3.9),
                new Student(4, "Alex", 3.7),
                new Student(5, "Alice", 3.6)
        ));
        return studentService.findAll();
    }

    @GetMapping("/")
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @PostMapping("/addAll")
    public List<Student> addAll(List<Student> students) {
        studentService.saveAll(students);
        return studentService.findAll();
    }

    @PostMapping("/add")
    public Student add(Student student) {
        studentService.save(student);
        return student;
    }
}

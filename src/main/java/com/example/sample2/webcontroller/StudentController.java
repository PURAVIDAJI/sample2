package com.example.sample2.webcontroller;

import com.example.sample2.domain.Score;
import com.example.sample2.domain.Student;
import com.example.sample2.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/list")
    public String findAll(Model m) {
        List<Student> students = studentService.findAll();
        m.addAttribute("students", students);
        return "student/studentList";
    }
    @GetMapping("/detail/{id}")
    public String findById(@PathVariable int id, Model m){
        Student detail = studentService.findById(id);
        m.addAttribute("detail",detail);
        return "student/studentDetail";
    }

    @GetMapping("/register")
    public String insertStudent() {
        return "student/studentInsert";
    }


    @PostMapping("/register")
    public String insertStudent(@ModelAttribute Student student) {
        studentService.insertStudent(student);
        return "redirect:/student/list";

    }

    //update
    @GetMapping("/update/{id}")
    public String updateStudent(@PathVariable int id, Model m) {
        Student selected = studentService.findById(id);
        m.addAttribute("selected", selected);

        return "student/studentScore";
    }

    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable int id,
                                @ModelAttribute Score score) {
        studentService.updateStudent(id, score);

        return "redirect:/student/list";
    }


}

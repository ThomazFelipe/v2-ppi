package com.unitri.ppi.v2.controller;

import com.unitri.ppi.v2.data.domain.Instructor;
import com.unitri.ppi.v2.data.domain.Student;
import com.unitri.ppi.v2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {

    private StudentService service;

    @Autowired
    public StudentController (StudentService service) {

        this.service = service;
    }

    @RequestMapping( value = "/students", method = RequestMethod.GET )
    public String list (Model model) {
        model.addAttribute("students", service.getStudents());
        return "students";
    }

    @RequestMapping( "student/{id}" )
    public String show (@PathVariable Long id, Model model) {
        model.addAttribute("student", service.getStudentById(id));
        return "studentsshow";
    }

    @RequestMapping( "student/edit/{id}" )
    public String edit (@PathVariable Long id, Model model) {
        model.addAttribute("student", service.getStudentById(id));
        return "studentsform";
    }

    @RequestMapping( "/student/new" )
    public String add (Model model) {
        model.addAttribute("student", new Instructor());
        return "studentform";
    }

    @RequestMapping( value = "student", method = RequestMethod.POST )
    public String save (Student student) {
        service.saveAndFlush(student);
        return "redirect:/student/" + student.getId();
    }


    @RequestMapping( "student/delete/{id}" )
    public String delete (@PathVariable Long id) {
        service.delete(id);
        return "redirect:/students";
    }
}

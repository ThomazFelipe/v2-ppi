package com.unitri.ppi.v2.controller;

import com.unitri.ppi.v2.data.domain.City;
import com.unitri.ppi.v2.data.domain.Grade;
import com.unitri.ppi.v2.service.CarService;
import com.unitri.ppi.v2.service.GradeService;
import com.unitri.ppi.v2.service.InstructorService;
import com.unitri.ppi.v2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GradeController {

    private GradeService service;
    private StudentService studentService;
    private InstructorService instructorService;
    private CarService carService;

    @Autowired
    public GradeController( GradeService service,
                            StudentService studentService,
                            InstructorService instructorService,
                            CarService carService ){

        this.service = service;
        this.studentService = studentService;
        this.instructorService = instructorService;
        this.carService = carService;
    }

    @RequestMapping( value = "/grades", method = RequestMethod.GET )
    public String list (Model model) {
        model.addAttribute("grades", service.getGrades());
        return "grades";
    }

    @RequestMapping( "grade/{id}" )
    public String show (@PathVariable Long id, Model model) {
        model.addAttribute("grade", service.getGradeById(id));
        return "gradeshow";
    }

    @RequestMapping( "grade/edit/{id}" )
    public String edit (@PathVariable Long id, Model model) {
        model.addAttribute("grade", service.getGradeById(id));
        model.addAttribute( "students", studentService.getStudents() );
        model.addAttribute( "instructors", instructorService.getInstructors() );
        return "gradeform";
    }

    @RequestMapping( "/grade/new" )
    public String add (Model model) {
        model.addAttribute("grade", new Grade());
        model.addAttribute( "students", studentService.getStudents() );
        model.addAttribute( "instructors", instructorService.getInstructors() );
        model.addAttribute( "cars", carService.getCars() );
        return "gradeform";
    }

    @RequestMapping( value = "grade", method = RequestMethod.POST )
    public String save (Grade grade) {
        service.saveAndFlush(grade);
        return "redirect:/grade/" + grade.getId();
    }


    @RequestMapping( "grade/delete/{id}" )
    public String delete (@PathVariable Long id) {
        service.delete(id);
        return "redirect:/grades";
    }
}

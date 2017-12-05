package com.unitri.ppi.v2.controller;

import com.unitri.ppi.v2.data.domain.Instructor;
import com.unitri.ppi.v2.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InstructorController {

    private InstructorService service;

    @Autowired
    public InstructorController (InstructorService service) {

        this.service = service;
    }

    @RequestMapping( value = "/instructors", method = RequestMethod.GET )
    public String list (Model model) {
        model.addAttribute("instructors", service.getInstructors());
        return "instructors";
    }

    @RequestMapping( "instructor/{id}" )
    public String show (@PathVariable Long id, Model model) {
        model.addAttribute("instructor", service.getInstructorById(id));
        return "instructorshow";
    }

    @RequestMapping( "instructor/edit/{id}" )
    public String edit (@PathVariable Long id, Model model) {
        model.addAttribute("instructor", service.getInstructorById(id));
        return "instructorform";
    }

    @RequestMapping( "/instructor/new" )
    public String add (Model model) {
        model.addAttribute("instructor", new Instructor());
        return "instructorform";
    }

    @RequestMapping( value = "instructor", method = RequestMethod.POST )
    public String save (Instructor instructor) {
        service.saveAndFlush(instructor);
        return "redirect:/instructor/" + instructor.getId();
    }


    @RequestMapping( "instructor/delete/{id}" )
    public String delete (@PathVariable Long id) {
        service.delete(id);
        return "redirect:/instructors";
    }
}

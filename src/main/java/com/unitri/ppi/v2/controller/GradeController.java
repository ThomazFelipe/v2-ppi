package com.unitri.ppi.v2.controller;

import com.unitri.ppi.v2.data.domain.City;
import com.unitri.ppi.v2.data.domain.Grade;
import com.unitri.ppi.v2.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GradeController {

    private GradeService service;

    @Autowired
    public GradeController (GradeService service) {

        this.service = service;
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
        return "gradeform";
    }

    @RequestMapping( "/grade/new" )
    public String add (Model model) {
        model.addAttribute("class", new City());
        return "gradeform";
    }

    @RequestMapping( value = "class", method = RequestMethod.POST )
    public String save (Grade classx) {
        service.saveAndFlush(classx);
        return "redirect:/class/" + classx.getId();
    }


    @RequestMapping( "class/delete/{id}" )
    public String delete (@PathVariable Long id) {
        service.delete(id);
        return "redirect:/classes";
    }
}

package com.unitri.ppi.v2.controller;

import com.unitri.ppi.v2.data.domain.City;
import com.unitri.ppi.v2.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CityController {

    private CityService service;

    @Autowired
    public CityController (CityService service) {

        this.service = service;
    }

    @RequestMapping( value = "/cities", method = RequestMethod.GET )
    public String list (Model model) {
        model.addAttribute("cities", service.getCities());
        return "cities";
    }

    @RequestMapping( "city/{id}" )
    public String show (@PathVariable Long id, Model model) {
        model.addAttribute("city", service.getCityById(id));
        return "cityshow";
    }

    @RequestMapping( "city/edit/{id}" )
    public String edit (@PathVariable Long id, Model model) {
        model.addAttribute("city", service.getCityById(id));
        return "cityform";
    }

    @RequestMapping( "/city/new" )
    public String add (Model model) {
        model.addAttribute("city", new City());
        return "cityform";
    }

    @RequestMapping( value = "city", method = RequestMethod.POST )
    public String save (City city) {
        service.saveAndFlush(city);
        return "redirect:/city/" + city.getId();
    }


    @RequestMapping( "city/delete/{id}" )
    public String delete (@PathVariable Long id) {
        service.delete(id);
        return "redirect:/cities";
    }
}

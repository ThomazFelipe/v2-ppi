package com.unitri.ppi.v2.controller;

import com.unitri.ppi.v2.data.domain.Car;
import com.unitri.ppi.v2.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CarController {

    private final CarService service;

    @Autowired
    public CarController (CarService service) {

        this.service = service;
    }

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("cars", service.getCars());
        return "cars";
    }


    @RequestMapping("car/{id}")
    public String showCar(@PathVariable Long id, Model model) {
        model.addAttribute("car", service.getCarById(id));
        return "carshow";
    }

    @RequestMapping("car/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("car", service.getCarById(id));
        return "carform";
    }

    @RequestMapping("car/new")
    public String newCar(Model model) {
        model.addAttribute("car", new Car());
        return "carform";
    }

    @RequestMapping(value = "car", method = RequestMethod.POST)
    public String saveCar(Car car) {
        service.saveAndFlush(car);
        return "redirect:/car/" + car.getId();
    }

    @RequestMapping("car/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/cars";
    }
}

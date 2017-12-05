package com.unitri.ppi.v2.controller;

import com.unitri.ppi.v2.data.domain.Address;
import com.unitri.ppi.v2.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AddressController {

    private final AddressService service;

    @Autowired
    public AddressController (AddressService service) {
        this.service = service;
    }

    @RequestMapping( value = "/addresses", method = RequestMethod.GET )
    public String list (Model model) {
        model.addAttribute("addresses", service.getAddresses());
        return "addresses";
    }

    @RequestMapping( "address/{id}" )
    public String show (@PathVariable Long id, Model model) {
        model.addAttribute("address", service.getAddressById(id));
        return "addressshow";
    }

    @RequestMapping( "address/edit/{id}" )
    public String edit (@PathVariable Long id, Model model) {
        model.addAttribute("address", service.getAddressById(id));
        return "addressform";
    }

    @RequestMapping( "/address/new" )
    public String add (Model model) {
        model.addAttribute("address", new Address());
        return "addressform";
    }

    @RequestMapping( value = "address", method = RequestMethod.POST )
    public String save (Address address) {
        service.saveAndFlush(address);
        return "redirect:/address/" + address.getId();
    }


    @RequestMapping( "address/delete/{id}" )
    public String delete (@PathVariable Long id) {
        service.delete(id);
        return "redirect:/addresses";
    }

}

package com.addressbok.addressbok;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller

public class HomeController {

    @Autowired
    AddressbookRepository addressbookRepository;

    @RequestMapping("/")
    public String listAddressbooks(Model model){
        model.addAttribute("addressbooks",addressbookRepository.findAll());
        return"list";
    }



    @GetMapping("/add")
    public String addressForm(Model model){
        model.addAttribute("addressbook", new Addressbook());
        return "addressForm";
    }
    @PostMapping("/process")
    public String processForm(@Valid Addressbook addressbook, BindingResult result) {
        if (result.hasErrors()) {
            return "addressForm";

        }
        addressbookRepository.save(addressbook);
        return "redirect:/";
    }

    @RequestMapping("/detail/{id}")
    public String showAddressbook(@PathVariable("id") long id, Model model){
        model.addAttribute("addressbook", addressbookRepository.findOne(id));
        return "show";

    }


    @RequestMapping("/update/{id}")
    public String updateAddressbook(@PathVariable("id") long id, Model model) {
        model.addAttribute("addressbook", addressbookRepository.findOne(id));
        return "addressForm";

    }
    @RequestMapping("/search")
    public String search (@RequestParam("n") String nameofpeople, Model model1) {

        model1.addAttribute("list", addressbookRepository.findAllBynameofpeople(nameofpeople));
        return "list";
    }


        @RequestMapping("/delete/{id}")
    public String delAddressbook(@PathVariable("id") long id){
        addressbookRepository.delete(id);
        return "redirect:/";
    }

}

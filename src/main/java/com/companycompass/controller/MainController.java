package com.companycompass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @GetMapping("/")
    @ModelAttribute
    public ModelAndView index(Model model) {
        model.addAttribute("content", "index");
        model.addAttribute("pageTitle", "Home");
        return new ModelAndView("layout");
    }

    @GetMapping("/web/company/add")
    public ModelAndView addCompany(Model model) {
        model.addAttribute("content", "addcompany");
        model.addAttribute("pageTitle", "Add Company");
        return new ModelAndView("layout");
    }

    @GetMapping("/about")
    @ModelAttribute
    public ModelAndView about(Model model) {
        model.addAttribute("content", "about");
        model.addAttribute("pageTitle", "About");
        return new ModelAndView("layout");
    }

    @GetMapping("/contact")
    @ModelAttribute
    public ModelAndView contact(Model model) {
        model.addAttribute("content", "contact");
        model.addAttribute("pageTitle", "Contact");
        return new ModelAndView("layout");
    }
}

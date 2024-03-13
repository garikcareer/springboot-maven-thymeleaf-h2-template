package com.example.springbootexample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @GetMapping("/")
    @ModelAttribute
    public ModelAndView index(Model model) {
        model.addAttribute("content", "index");
        return new ModelAndView("layout");
    }

    @GetMapping("/home")
    @ModelAttribute
    public ModelAndView home(Model model) {
        model.addAttribute("content", "index");
        return new ModelAndView("layout");
    }

    @GetMapping("/about")
    @ModelAttribute
    public ModelAndView about(Model model) {
        model.addAttribute("content", "about");
        return new ModelAndView("layout");
    }
}

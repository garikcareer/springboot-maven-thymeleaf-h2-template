package com.example.springbootexample.controller;

import com.example.springbootexample.model.Company;
import com.example.springbootexample.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private CompanyService companyService;

    @GetMapping("/")
    @ModelAttribute
    public ModelAndView index(Model model) {
        List<Company> companies = companyService.getCompanies();
        model.addAttribute("companyList", companies);
        return new ModelAndView("index");
    }
}

package com.example.springbootexample.controller;

import com.example.springbootexample.model.Company;
import com.example.springbootexample.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(path="/web/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping("")
    @ModelAttribute
    public ModelAndView company(Model model) {
        List<Company> companies = companyService.getCompanies();
        model.addAttribute("content", "company");
        model.addAttribute("pageTitle", "Companies");
        model.addAttribute("companyList", companies);
        return new ModelAndView("layout");
    }
}


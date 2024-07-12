package com.example.companycompass.controllers;

import com.example.companycompass.repository.CompanyRepository;
import com.example.companycompass.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/web/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping("")
    @ModelAttribute
    public ModelAndView getAllCompanies(Model model) {
        model.addAttribute("content", "company");
        model.addAttribute("pageTitle", "Companies");
        model.addAttribute("companyList", companyService.getCompanies());
        return new ModelAndView("layout");
    }
}

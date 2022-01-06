package dev.danielviana.relatorio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reports")
public class ReportController {
    
    @GetMapping("/html")
    public String html(Model model){
        return "report/index";
    }

}

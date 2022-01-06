package dev.danielviana.relatorio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dev.danielviana.relatorio.services.CityService;
import dev.danielviana.relatorio.services.StateService;

@Controller
@RequestMapping("/reports")
public class ReportController {
    
    private StateService stateService;

    private CityService cityService;

    @Autowired
    public ReportController(StateService stateService, CityService cityService) {
        this.stateService = stateService;
        this.cityService = cityService;
    }

    @GetMapping("/html")
    public String html(@RequestParam(required = false, value="state") Long id, Model model){
        model.addAttribute("states", stateService.findAll());

        if(id == null){
            return "report/index";
        }
        
        model.addAttribute("list", cityService.reportAllCitiesByState(id));
        return "report/index";
    }


}

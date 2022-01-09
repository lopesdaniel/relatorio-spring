package dev.danielviana.relatorio.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dev.danielviana.relatorio.model.ReportChart;
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
    
    @GetMapping("/chart")
    public String chart(Model model){
        List<ReportChart> list = stateService.countCitiesByState();

        model.addAttribute("labels", list.stream().map(ReportChart::getName).collect(Collectors.toList()));
        model.addAttribute("data", list.stream().map(ReportChart::getTotal).collect(Collectors.toList()));
        return "report/chart";
    }

}

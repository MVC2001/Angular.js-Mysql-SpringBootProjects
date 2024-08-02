package com.obms.controller;

import com.obms.entity.Injury;
import com.obms.service.impl.InjuryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class InjuryController {

      @Autowired
      private InjuryService injuryService;


    @GetMapping("/injuryAccount")
    public ModelAndView injuryPage(){
        List<Injury> list= injuryService.getAllInjuries();
        return new ModelAndView("injuryAccount","injury",list);
    }



    @GetMapping("/saveInjuries")
    public  String injuryForm(){
        return  "saveInjuries";
    }



    @PostMapping("/saveInjuries")
    public  String addInjury(@ModelAttribute Injury injury){
        injuryService.saveInjury(injury);
        return "redirect:/injuryAccount?success";
    }


    @RequestMapping("/InjuryEdit/{id}")
    public  String editInjury(@PathVariable("id") Long id, Model model){
        Injury injury = injuryService.getInjuryById(id);
        model.addAttribute("injury", injury);
        return "InjuryEdit";
    }



    @RequestMapping("/deleteInjury/{id}")
    public  String deleteInjury(@PathVariable("id") Long id){
        injuryService.deleteInjuryById(id);
        return "redirect:/injuryAccount";
    }
}

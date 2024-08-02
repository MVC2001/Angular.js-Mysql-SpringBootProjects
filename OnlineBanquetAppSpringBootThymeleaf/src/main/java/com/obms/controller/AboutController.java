package com.obms.controller;

import com.obms.entity.About;
import com.obms.service.impl.AboutServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AboutController {

    @Autowired
    private AboutServices aboutServices;


    @GetMapping("/about/index")
    public ModelAndView AboutPage(){
        List<About> list= aboutServices.getAllAboutPosts();
        return new ModelAndView("/about/index","about",list);
    }



    @GetMapping("/saveAboutPost")
    public  String SaveAboutPosts(){
        return "about/saveAboutPost";
    }



    @PostMapping("/saveAboutPost")
    public  String addAboutsPosts(@ModelAttribute About about){
        aboutServices.saveAboutPosts(about);
        return "redirect:/about/index?success";
    }


    @RequestMapping("/about/PostAboutEditForm/{id}")
    public  String editPost(@PathVariable("id") Long id, Model model){
        About about = aboutServices.getAboutPostsById(id);
        model.addAttribute("about", about);
        return "/about/PostAboutEditForm";
    }



    @RequestMapping("/deletePost/{id}")
    public  String deleteAbooutPost(@PathVariable("id") Long id){
        aboutServices.deleteAboutPostsById(id);
        return "redirect:/about/index";
    }
}


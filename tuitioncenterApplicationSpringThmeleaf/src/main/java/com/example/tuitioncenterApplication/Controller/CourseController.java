package com.example.tuitioncenterApplication.Controller;


import com.example.tuitioncenterApplication.Entity.Course;
import com.example.tuitioncenterApplication.Entity.Payment;
import com.example.tuitioncenterApplication.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CourseController {

    @Autowired private CourseService courseService;


    @GetMapping("/GetAllcourses")
    public ModelAndView getAllcourse(){
        List<Course> list= courseService.getAllcourses();
        return new ModelAndView("coursePage","course",list);
    }

    @GetMapping("/addCoursePage")
    public  String addCoursePage(){

        return "addCourse";
    }


    @PostMapping("/saveCourse")
    public  String addCourse(@ModelAttribute Course course){
        courseService.saveCourse(course);
        return "redirect:/GetAllcourses";
    }



    @RequestMapping("/editCourse/{id}")
    public  String editCourse(@PathVariable("id") long id, Model model){
        Course course = courseService.getCourseById(id);
        model.addAttribute("course", course);
        return "courseEdit";
    }

    @RequestMapping("/deleteCourse/{id}")
    public  String deleteCourse(@PathVariable("id") long id){
        courseService.deleteCourseById(id);
        return "redirect:/GetAllcourses";
    }
}

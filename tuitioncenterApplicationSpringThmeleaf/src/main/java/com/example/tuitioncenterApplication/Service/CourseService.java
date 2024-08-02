package com.example.tuitioncenterApplication.Service;

import com.example.tuitioncenterApplication.Entity.Course;
import com.example.tuitioncenterApplication.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {


    @Autowired
    private CourseRepository courseRepository;

    public  void saveCourse(Course course){
        courseRepository.save(course);
    }

    public List<Course> getAllcourses(){
        return  courseRepository.findAll();
    }

    public Course getCourseById(Long id){

        return courseRepository.findById(id).get();
    }

    public  void deleteCourseById(long id){
        courseRepository.deleteById(id);
    }
}

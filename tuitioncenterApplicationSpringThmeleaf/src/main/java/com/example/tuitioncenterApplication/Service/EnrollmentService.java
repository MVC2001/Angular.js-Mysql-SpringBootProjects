package com.example.tuitioncenterApplication.Service;


import com.example.tuitioncenterApplication.Entity.Enrollment;
import com.example.tuitioncenterApplication.Repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {


    @Autowired
    private EnrollmentRepository enrollmentRepository;

    public  void saveEnrollment(Enrollment enrollment){
        enrollmentRepository.save(enrollment);
    }

    public List<Enrollment> getAllenrollments(){
        return  enrollmentRepository.findAll();
    }

    public Enrollment getEnrollsById(Integer id){

        return enrollmentRepository.findById(id).get();
    }


    public  void deleteEnollmentById(Integer id){
        enrollmentRepository.deleteById(id);
    }


}

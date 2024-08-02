package com.example.tuitioncenterApplication.Repository;

import com.example.tuitioncenterApplication.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository  extends JpaRepository<Course, Long> {
}

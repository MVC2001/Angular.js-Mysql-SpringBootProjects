package com.example.tuitioncenterApplication.Repository;

import com.example.tuitioncenterApplication.Entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository  extends JpaRepository<Enrollment, Integer> {
}

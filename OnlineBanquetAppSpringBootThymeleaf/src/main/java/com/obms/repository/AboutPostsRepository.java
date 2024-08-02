package com.obms.repository;

import com.obms.entity.About;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AboutPostsRepository extends JpaRepository<About, Long> {
}

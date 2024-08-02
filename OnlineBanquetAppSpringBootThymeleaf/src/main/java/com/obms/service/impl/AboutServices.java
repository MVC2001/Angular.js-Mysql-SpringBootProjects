package com.obms.service.impl;

import com.obms.entity.About;
import com.obms.repository.AboutPostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AboutServices {

    @Autowired
    private AboutPostsRepository aboutPostsRepository;

    public  void saveAboutPosts(About about){
        aboutPostsRepository.save(about);
    }

    public List<About> getAllAboutPosts(){
        return  aboutPostsRepository.findAll();
    }

    public About getAboutPostsById(Long id){

        return aboutPostsRepository.findById(id).get();
    }

    public  void deleteAboutPostsById(Long id){
        aboutPostsRepository.deleteById(id);
    }
}

package com.obms.service.impl;

import com.obms.entity.ServiceEntity;
import com.obms.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceServiceImp {

    @Autowired
    private ServiceRepository serviceRepository;

    public  void saveServicePosts(ServiceEntity service){
        serviceRepository.save(service);
    }

    public List<ServiceEntity> getAllServicePosts(){
        return  serviceRepository.findAll();
    }

    public ServiceEntity getServicePostsById(Long id){

        return serviceRepository.findById(id).get();
    }

    public  void deleteServicePostsById(Long id){
        serviceRepository.deleteById(id);
    }
}

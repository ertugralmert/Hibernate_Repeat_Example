package com.mert.service;

import com.mert.entity.Unvan;
import com.mert.repository.UnvanRepository;

import java.util.List;

public class UnvanService {

    private final UnvanRepository unvanRepository;

    public UnvanService(){
        unvanRepository = new UnvanRepository();
    }

    public Unvan save (Unvan unvan){
     return unvanRepository.save(unvan);

    }

    public List<Unvan> listeleme(){
       return unvanRepository.findAll();
    }
}

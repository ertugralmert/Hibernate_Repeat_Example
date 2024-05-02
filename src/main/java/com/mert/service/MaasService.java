package com.mert.service;

import com.mert.entity.Maas;
import com.mert.repository.MaasRepository;

import java.util.List;

public class MaasService {
    private final MaasRepository maasRepository;

    public MaasService(){
        maasRepository = new MaasRepository();
    }

    public Maas save(Maas maas){
    return     maasRepository.save(maas);
    }

    public List<Maas> listeleme(){
     return maasRepository.findAll();
    }
}

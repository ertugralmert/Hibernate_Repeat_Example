package com.mert.repository;

import com.mert.entity.Maas;

public class MaasRepository extends Repository<Maas,Long> {
    public MaasRepository() {
        super(new Maas());
    }
}

package com.mert.repository;

import com.mert.entity.Unvan;

public class UnvanRepository extends Repository<Unvan,Long> {
    public UnvanRepository( ) {
        super(new Unvan());
    }
}

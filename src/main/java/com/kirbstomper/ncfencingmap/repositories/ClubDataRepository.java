package com.kirbstomper.ncfencingmap.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.kirbstomper.ncfencingmap.models.ClubData;

@Repository
public interface ClubDataRepository extends ReactiveCrudRepository<ClubData, String> {
    
}

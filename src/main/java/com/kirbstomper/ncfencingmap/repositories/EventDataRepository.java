package com.kirbstomper.ncfencingmap.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.kirbstomper.ncfencingmap.models.EventData;

@Repository
public interface EventDataRepository extends ReactiveCrudRepository<EventData, String> {
    
}

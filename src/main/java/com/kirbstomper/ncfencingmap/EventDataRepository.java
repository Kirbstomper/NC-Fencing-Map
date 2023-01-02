package com.kirbstomper.ncfencingmap;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventDataRepository extends ReactiveCrudRepository<EventData, String> {
    
}

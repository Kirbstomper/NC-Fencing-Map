package com.kirbstomper.ncfencingmap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Builder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/clubs")
@Builder
public class ClubDataController {

    @Autowired
    ClubDataRepository clubDataRepository;

    @PostMapping("create")
    public Mono<ClubDTO> create(@RequestBody ClubDTO club){
        return clubDataRepository.save(club.mapToClubData()).map(ClubData::mapToClubDTO);
    }
    

    @GetMapping("getAllClubs")
    public Flux<ClubDTO> getAllClubs(){
        return clubDataRepository.findAll().map(ClubData::mapToClubDTO);
    }
}

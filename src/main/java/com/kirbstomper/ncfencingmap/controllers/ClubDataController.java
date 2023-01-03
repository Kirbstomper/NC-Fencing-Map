package com.kirbstomper.ncfencingmap.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kirbstomper.ncfencingmap.dto.ClubDataDTO;
import com.kirbstomper.ncfencingmap.models.ClubData;
import com.kirbstomper.ncfencingmap.repositories.ClubDataRepository;

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
    public Mono<ClubDataDTO> create(@RequestBody ClubDataDTO club){
        return clubDataRepository.save(club.mapToClubData()).map(ClubData::mapToClubDTO);
    }
    

    @GetMapping("getAllClubs")
    public Flux<ClubDataDTO> getAllClubs(){
        return clubDataRepository.findAll().map(ClubData::mapToClubDTO);
    }
}

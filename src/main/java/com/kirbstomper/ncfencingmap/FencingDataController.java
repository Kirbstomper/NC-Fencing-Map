package com.kirbstomper.ncfencingmap;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/api/events")
public class FencingDataController {
    @Autowired
    EventDataRepository eventDataRepository;

    @GetMapping("/getEvents")
    public Flux<EventDataDTO> getEvents() {
        log.debug("Returning all event data");
        return eventDataRepository.findAll().map(EventData::mapToDTO);
    }

    @PostMapping("/addEvent")
    public Mono<EventDataDTO> addEvent(@RequestBody EventDataDTO eventDataDTO) {
        log.debug("Adding new event, or updating existing one");
        return eventDataRepository.save(eventDataDTO.mapToEventData()).map(EventData::mapToDTO);
    }

    @PostMapping("/addManyEvent")
    public Flux<EventDataDTO> addEvent(@RequestBody List<EventDataDTO> eventDataDTOList) {
        log.debug("Adding new event, or updating existing one");
        return eventDataRepository.saveAll(eventDataDTOList.stream().map(
                EventDataDTO::mapToEventData)
                .collect(Collectors.toList())).map(EventData::mapToDTO);
    }

    @DeleteMapping("/cleanEvents")
    public Mono<Void> cleanEvents() {
        return eventDataRepository.deleteAll();
    }

}

package com.kirbstomper.ncfencingmap;

import java.util.List;
import java.util.UUID;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class StartupInitialization  {
  private final EventDataRepository repository;

  @EventListener
  public void onApplicationEvent(ContextRefreshedEvent event) {
    log.info("Increment counter");
    
    repository.deleteAll().block();
    List<String> clubs = List.of("GSO", "FORGE","UNCC", "UNCG" );
    List<String> address = List.of("5300 Sterling Forest Dr", "Greensboro Fencing Academy", "Forge Fencing Academy");
    var counter = 0;
    for(String add: address){
      repository.save(new EventData.EventDataBuilder()
      .address(add)
      .clubs(clubs)
      .eventName("Event: " + counter++)
      .eventID(UUID.randomUUID().toString())
      .location(GeoCoder.getBestLocation(add))
      .build()).block();
    }

  }
}
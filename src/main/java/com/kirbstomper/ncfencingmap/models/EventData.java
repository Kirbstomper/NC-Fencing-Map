package com.kirbstomper.ncfencingmap.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.google.maps.model.LatLng;
import com.kirbstomper.ncfencingmap.dto.EventDataDTO;

import lombok.Builder;
import lombok.Data;

@Document("eventdata")
@Data
@Builder
public class EventData {
    @Id
    String eventId;
    String eventName;
    List<String> clubs;
    String address;
    LatLng location;

    public EventDataDTO mapToDTO() {

        return EventDataDTO.builder()
                .eventId(eventId)
                .eventName(eventName)
                .address(address)
                .clubs(clubs)
                .location(location)
                .build();
    }
}

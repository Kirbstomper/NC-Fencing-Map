package com.kirbstomper.ncfencingmap;

import java.util.List;

import com.google.maps.model.LatLng;

import lombok.Builder;

@Builder
public record EventDataDTO(String eventId, String eventName, List<String> clubs, String address, LatLng location) {
    public EventData mapToEventData() {
        return EventData.builder()
                .eventId(eventId())
                .eventName(eventName())
                .address(address())
                .clubs(clubs())
                .location(GeoCoder.getBestLocation(address()))
                .build();
    }

}
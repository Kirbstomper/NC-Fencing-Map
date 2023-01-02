package com.kirbstomper.ncfencingmap;

import java.util.List;

public record EventDataDTO(String eventId, String eventName, List<String> clubs, String address) {

    public EventData mapToEventData() {
        return EventData.builder()
                .eventID(eventId())
                .eventName(eventName())
                .address(address())
                .clubs(clubs())
                .build();
    }

}
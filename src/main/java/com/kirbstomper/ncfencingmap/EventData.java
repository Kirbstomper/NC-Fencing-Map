package com.kirbstomper.ncfencingmap;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Document("eventdata")
@Data
@Builder
public class EventData {
    @Id
    String eventID;
    String eventName;
    List<String> clubs;
    String address;


    public EventDataDTO mapToDTO(){

        return new EventDataDTO(eventID, eventName, clubs, address);
    }
}

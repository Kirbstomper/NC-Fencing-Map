package com.kirbstomper.ncfencingmap.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.google.maps.model.LatLng;
import com.kirbstomper.ncfencingmap.dto.ClubDataDTO;

import lombok.Builder;
import lombok.Data;

/***
 * Information related to a club, should be used to locate club and link back to club
 */
@Data
@Builder
@Document("clubs")
public class ClubData {
    String code;
    String name;
    String website;
    String address;
    List<String> fencers;
    LatLng position;

    public ClubDataDTO mapToClubDTO(){
        return ClubDataDTO.builder()
        .code(code)
        .name(name)
        .website(website)
        .address(address)
        .position(position)
        .build();
    }
}






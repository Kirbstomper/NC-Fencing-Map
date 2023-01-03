package com.kirbstomper.ncfencingmap.models;

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






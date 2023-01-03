package com.kirbstomper.ncfencingmap;

import org.springframework.data.mongodb.core.mapping.Document;

import com.google.maps.model.LatLng;

import lombok.Builder;
import lombok.Data;

/***
 * Information related to a club, should be used to locate club and link back to club
 */
@Data
@Builder
@Document("clubs")
public class Club {
    String code;
    String name;
    String website;
    String address;
    LatLng position;
}




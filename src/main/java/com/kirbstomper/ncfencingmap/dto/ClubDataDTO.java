package com.kirbstomper.ncfencingmap.dto;

import com.google.maps.model.LatLng;
import com.kirbstomper.ncfencingmap.models.ClubData;

import lombok.Builder;

@Builder
public record ClubDataDTO(String code,
        String name,
        String website,
        String address,
        LatLng position) {

    public ClubData mapToClubData() {
        return ClubData.builder()
                .code(code)
                .name(name)
                .website(website)
                .address(address)
                .position(position)
                .build();
    }

}

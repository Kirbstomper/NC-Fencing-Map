package com.kirbstomper.ncfencingmap;

import com.google.maps.model.LatLng;

import lombok.Builder;

@Builder
public record ClubDTO(String code,
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

package com.kirbstomper.ncfencingmap.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller("WebController")
@Slf4j
public class WebController {
    @Value("${GOOGLE_MAPS_API_KEY:'maps_api_key'}")
    private String googleMapsApiKey = "Pain";

    @RequestMapping(value = "/index")
    public String index(Model model) {
        log.info(googleMapsApiKey);
        return "index";
    }

    public String getApiKey(){
        return googleMapsApiKey;
    }
}

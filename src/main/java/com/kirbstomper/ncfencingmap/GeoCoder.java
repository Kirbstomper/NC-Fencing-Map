package com.kirbstomper.ncfencingmap;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;


public class GeoCoder {

    static GeoApiContext context = new GeoApiContext.Builder().apiKey(System.getenv("GOOGLE_MAPS_API_KEY")).build();

    public static LatLng getBestLocation(String address) {
        GeocodingResult[] results = null;
        try {
            results = GeocodingApi.geocode(context,
                    address).await();
        } catch (ApiException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(results[0].geometry.location));
        return results[0].geometry.location;
    }

}

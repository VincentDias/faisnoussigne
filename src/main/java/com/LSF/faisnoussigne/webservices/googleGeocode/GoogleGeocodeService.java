package com.LSF.faisnoussigne.webservices.googleGeocode;

import com.LSF.faisnoussigne.webservices.googleGeocode.models.GoogleGeocode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


@Service
public class GoogleGeocodeService {

    public GoogleGeocode getData(String address){

        WebClient webClient = WebClient
                .builder()
                .baseUrl("https://maps.googleapis.com/maps/api/geocode")
                .build();

        return webClient.get()

                .uri(UriBuilder -> UriBuilder
                        .path("/json")
                        .queryParam("address", address)
                        .queryParam("key", System.getenv("google_api_key"))
                        .build())
                .retrieve()
                .bodyToMono(GoogleGeocode.class).block();

    }

}
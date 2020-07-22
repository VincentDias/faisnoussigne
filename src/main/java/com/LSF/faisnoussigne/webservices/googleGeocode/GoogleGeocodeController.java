package com.LSF.faisnoussigne.webservices.googleGeocode;

import com.LSF.faisnoussigne.webservices.googleGeocode.models.GoogleGeocode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/map-api")
public class GoogleGeocodeController {

    @Autowired GoogleGeocodeService service;

    @GetMapping
    public GoogleGeocode getData(@RequestParam String address){
        return service.getData(address);
    }
}

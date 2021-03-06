package cst438hw2.controller;

//Great formatting Max. The description you used here will help the reader 
//see how to enter the URL into their browser
/**
 * This is the Rest controller which provides external Rest Service when user enter URL like
 *      http://localhost:8080/api/cities/Miami, 
 *      It will return a JSON format string containing Miami's info
 * 
 * @author Max Halbert
 * @since 2021-05-09
 */
/*
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import cst438hw2.domain.*;
import cst438hw2.service.CityService;

@RestController
public class CityRestController {

    @Autowired
    CityService cityService;

    @GetMapping("/api/cities/{city}")
    public ResponseEntity<CityInfo> getWeather(@PathVariable("city") String cityName) {
        return cityService.getCityInfo(cityName);
    }
}

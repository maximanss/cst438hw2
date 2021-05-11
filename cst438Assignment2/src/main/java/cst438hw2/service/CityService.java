package cst438hw2.service;

/**
 * This is the service class that gets city information from database and external weather server.
 * 
 * @author Max Halbert
 * @since 2021-05-09
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import cst438hw2.domain.*;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private WeatherService weatherService;

    // this constructor is used in test to stub out
    // cityRepository and weatherService.
    public CityService(CityRepository mockRepository, WeatherService mockWeather) {
        this.cityRepository = mockRepository;
        this.weatherService = mockWeather;
    }

    // it will return the city info in JSON format.
    public ResponseEntity<CityInfo> getCityInfo(String cityName) {
        // look up city info from database. Might be multiple cities with same name.
        List<City> cities = cityRepository.findByName(cityName);
        if (cities.size() == 0) {

            // city name not found. Send 404 return code.
            // return new CityInfo(HttpStatus.NOT_FOUND);
            return new ResponseEntity<CityInfo>(HttpStatus.NOT_FOUND);

        } else {
            // in case of multiple cities, take the first one.
            City city = cities.get(0);

            // call weather service to get temperature and time
            TempAndTime weather = weatherService.getTempAndTime(city.getName());
            city.setWeather(weather);

            CityInfo cityInfo = new CityInfo(city);

            return new ResponseEntity<CityInfo>(cityInfo, HttpStatus.OK);
        }

    }
}

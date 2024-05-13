package org.weather.place;

import org.springframework.stereotype.Service;
import org.weather.Place;

@Service
public class PlaceService {

    private final PlaceRepository placeRepository;
    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public String findStationnameByCountryAndArea(String country, String area) {
        Place place = placeRepository.findStationnameByCountryAndArea(country, area);
        return place.getStationName();
    }
}

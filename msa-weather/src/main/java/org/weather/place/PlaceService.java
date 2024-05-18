package org.weather.place;

import org.springframework.stereotype.Service;
import org.core.vo.Place;

@Service
public class PlaceService {

    private final PlaceRepository placeRepository;
    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public PlaceDto findByCountryAndArea(String country, String area) {
        Place place = placeRepository.findByCountryAndArea(country, area);
        return new PlaceDto(place.getCountry(), place.getArea(), place.getStationName());
    }
}

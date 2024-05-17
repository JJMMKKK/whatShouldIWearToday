package org.member.utilController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.core.vo.Place;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Slf4j
@Service
public class UtilService {

    private final UtilRepository utilRepository;

    public List<String> findCountries() {
        List<Place> places = utilRepository.findAll();
        Set<String> countrySet = new HashSet<>();
        for (Place place : places) {
            countrySet.add(place.getCountry());
        }
        return new ArrayList<>(countrySet);

    }

    public List<String> findAreasByCountry(String country) {
        List<Place> places = utilRepository.findByCountry(country);
        List<String> areas = new ArrayList<>();
        for (Place place : places) {
            if (place.getCountry().equals(country)) {
                areas.add(place.getArea());
            }
        }
        return areas;
    }
}

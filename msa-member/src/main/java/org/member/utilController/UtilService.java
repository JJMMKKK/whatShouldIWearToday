package org.member.utilController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.core.vo.Place;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class UtilService {

    private final UtilRepository utilRepository;

    public List<String> findAreasByCountry(String country) {
        List<Place> places = utilRepository.findAreaByCountry(country);
        List<String> areas = new ArrayList<>();
        for (Place place : places) {
            areas.add(place.getArea());
        }
        return areas;
    }
}

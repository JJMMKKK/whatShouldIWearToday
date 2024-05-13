package org.weather.place;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.weather.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Integer> {

    Place findStationnameByCountryAndArea(String country, String area);
}

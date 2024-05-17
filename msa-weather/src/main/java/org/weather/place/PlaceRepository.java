package org.weather.place;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.core.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Integer> {

    Place findByCountryAndArea(String country, String area);
}

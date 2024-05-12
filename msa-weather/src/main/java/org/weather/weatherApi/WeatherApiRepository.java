package org.weather.weatherApi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.weather.Weatherareavo;

@Repository
public interface WeatherApiRepository extends JpaRepository<Weatherareavo, Integer> {

    Weatherareavo findByArea(String area);
}
package org.weather.weatherApi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherApiRepository extends JpaRepository<Weatherareavo, Integer> {

    Weatherareavo findByArea(String area);
}
package org.weather.dustApi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.weather.Paticulatemattervo;

@Repository
public interface DustApiRepository extends JpaRepository<Paticulatemattervo, Integer> {

    @Transactional
    Paticulatemattervo findBysidonameAndStationname(String sidoname, String stationname);
}

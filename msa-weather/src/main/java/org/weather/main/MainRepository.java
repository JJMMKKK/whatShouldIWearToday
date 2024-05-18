package org.weather.main;

import org.core.vo.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MainRepository extends JpaRepository<Place, Integer> {
    List<Place> findByCountry(String country);
}

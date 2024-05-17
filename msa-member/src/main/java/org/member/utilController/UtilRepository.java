package org.member.utilController;

import org.core.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilRepository extends JpaRepository<Place, Integer> {

    List<Place> findAreaByCountry(String country);
}

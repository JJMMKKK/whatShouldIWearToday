package org.member.utilController;

import org.core.vo.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilRepository extends JpaRepository<Place, Integer> {

    List<Place> findByCountry(String country);
}

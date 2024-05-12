package org.weather.dustApi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.weather.Paticulatemattervo;

@Repository
public interface DustApiRepository extends JpaRepository<Paticulatemattervo, Integer> {

    @Transactional
    void deleteByStationname(String stationname);

    Paticulatemattervo findByStationname(String stationname);

//    @Transactional
//    @Modifying
//    @Query("update Paticulatemattervo p set p.sidoname = ?1, p.datatime = ?2, p.stationname = ?3, p.pm25grade = ?4, p.pm25flag = ?5, p.pm25value = ?6, p.pm10grade = ?7, p.pm10flag = ?8, p.pm10value = ?9")
//    int updateSidonameAndDatatimeAndStationnameAndPm25gradeAndPm25flagAndPm25valueAndPm10gradeAndPm10flagAndPm10valueBy(@NonNull String sidoname, @NonNull String datatime, @NonNull String stationname, @Nullable String pm25grade, @Nullable String pm25flag, @Nullable String pm25value, @Nullable String pm10grade, @Nullable String pm10flag, @Nullable String pm10value);

}

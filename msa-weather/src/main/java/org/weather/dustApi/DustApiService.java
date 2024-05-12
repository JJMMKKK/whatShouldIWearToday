package org.weather.dustApi;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.weather.Paticulatemattervo;
import org.weather.PaticulatemattervoDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DustApiService {

    private final DustApiRepository apiRepository;
    public DustApiService(DustApiRepository apiRepository) {
        this.apiRepository = apiRepository;
    }

    public void dustRequest(List<PaticulatemattervoDto> paticulateMatterList) {

        for(PaticulatemattervoDto dto : paticulateMatterList) {
            Paticulatemattervo paticulatemattervo = new Paticulatemattervo();
            BeanUtils.copyProperties(dto, paticulatemattervo);

            if(paticulatemattervo.getPm10flag() == null || paticulatemattervo.getPm25flag() == null) {
//                apiRepository.updateSidonameAndDatatimeAndStationnameAndPm25gradeAndPm25flagAndPm25valueAndPm10gradeAndPm10flagAndPm10valueBy(
//                        paticulatemattervo.getSidoname(), paticulatemattervo.getDatatime(),paticulatemattervo.getStationname(),
//                        paticulatemattervo.getPm25grade(),paticulatemattervo.getPm25flag(),paticulatemattervo.getPm25value(),
//                        paticulatemattervo.getPm10grade(),paticulatemattervo.getPm10flag(),paticulatemattervo.getPm10value());

                apiRepository.deleteByStationname(paticulatemattervo.getStationname());
                apiRepository.save(paticulatemattervo);
            }
        }
    }

    public PaticulatemattervoDto findByStationname(String stationname) {
        Paticulatemattervo paticulatemattervo = apiRepository.findByStationname(stationname);
        PaticulatemattervoDto paticulatemattervoDto = new PaticulatemattervoDto();
        BeanUtils.copyProperties(paticulatemattervo, paticulatemattervoDto);
        return paticulatemattervoDto;
    }
}

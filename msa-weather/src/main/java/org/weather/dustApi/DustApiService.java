package org.weather.dustApi;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.weather.place.PlaceDto;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class DustApiService {

    private final DustApiRepository dustApiRepository;

    public PaticulatemattervoDto findByStationname(PlaceDto placeDto) {
        Paticulatemattervo paticulatemattervo
                = dustApiRepository.findBysidonameAndStationname(placeDto.getCountry(), placeDto.getStationName());
        PaticulatemattervoDto paticulatemattervoDto = new PaticulatemattervoDto();
        BeanUtils.copyProperties(paticulatemattervo, paticulatemattervoDto);
        return paticulatemattervoDto;
    }

    public PQ selectDustDataForQuestionToGPT(PlaceDto placeDto) {
        Paticulatemattervo paticulatemattervo
                = dustApiRepository.findBysidonameAndStationname(placeDto.getCountry(), placeDto.getStationName());
        PQ pq = new PQ();
            BeanUtils.copyProperties(paticulatemattervo, pq);
            log.info("pq: {}", pq);
        return pq;
    }

    @Transactional
    public void dustRequest(List<PaticulatemattervoDto> paticulateMatterDtoList) {
        List<Paticulatemattervo> paticulatemattervoList = new ArrayList<>();
        for (PaticulatemattervoDto dto : paticulateMatterDtoList) {
                    Paticulatemattervo paticulatemattervo = new Paticulatemattervo();
                    BeanUtils.copyProperties(dto, paticulatemattervo);
                    paticulatemattervoList.add(paticulatemattervo);
        }
        log.info("paticulatemattervoList: {}", paticulatemattervoList);
        dustApiRepository.saveAll(paticulatemattervoList);
    }
}

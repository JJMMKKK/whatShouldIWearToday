package org.weather.dustApi;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.weather.Paticulatemattervo;
import org.weather.PaticulatemattervoDto;
import org.weather.PlaceDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class DustApiService {

    private final DustApiRepository apiRepository;
    public DustApiService(DustApiRepository apiRepository) {
        this.apiRepository = apiRepository;
    }

    @Transactional
    public void dustRequest(List<PaticulatemattervoDto> paticulateMatterDtoList) {
        List<Paticulatemattervo> saveList = new ArrayList<>();
        for (PaticulatemattervoDto dto : paticulateMatterDtoList) {
            if (dto.getPm10flag().equals("null") || dto.getPm25flag().equals("null")) {
                Paticulatemattervo paticulatemattervo = new Paticulatemattervo();
                BeanUtils.copyProperties(dto, paticulatemattervo);
                saveList.add(paticulatemattervo);
            }
        }
        System.out.println("saveList: " + saveList);
        apiRepository.deleteAll();
        apiRepository.saveAll(saveList);
    }

    public PaticulatemattervoDto findByStationname(PlaceDto placeDto) {

        Paticulatemattervo paticulatemattervo = apiRepository.findBysidonameAndStationname(placeDto.getCountry(), placeDto.getStationName());
        PaticulatemattervoDto paticulatemattervoDto = new PaticulatemattervoDto();
        BeanUtils.copyProperties(paticulatemattervo, paticulatemattervoDto);
        return paticulatemattervoDto;
    }
}

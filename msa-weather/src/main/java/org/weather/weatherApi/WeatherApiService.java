package org.weather.weatherApi;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WeatherApiService {

    public final WeatherApiRepository weatherApiRepository;

    public WeatherApiService(WeatherApiRepository weatherApiRepository){
        this.weatherApiRepository = weatherApiRepository;
    }

    public Map weatherRequest(String area) {
        Weatherareavo weatherareavo = weatherApiRepository.findByArea(area);
        if(weatherareavo == null){
            return null;
        }
        Map map = new HashMap();
            map.put("nx", weatherareavo.getNx());
            map.put("ny", weatherareavo.getNy());
        return map;
    }

    public List<String> findAllCountry() {
        List<Weatherareavo> list = weatherApiRepository.findAll();
        return list.stream().map(Weatherareavo::getEncodedCountry).distinct().toList();
    }
}

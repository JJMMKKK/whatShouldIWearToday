package org.weather.weatherApi;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WeatherApiService {

    public final WeatherApiRepository weatherApiRepository;

    public WeatherApiService(WeatherApiRepository weatherApiRepository){
        this.weatherApiRepository = weatherApiRepository;
    }

    public Map weatherRequest(String area) {
        Weatherareavo weatherareavo = weatherApiRepository.findByArea(area);
        Map map = new HashMap();
            map.put("nx", weatherareavo.getNx());
            map.put("ny", weatherareavo.getNy());
        return map;
    }
}

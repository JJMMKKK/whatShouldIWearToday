package org.weather.weatherApi;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.weather.dustApi.PQ;
import org.core.dto.WeatherareavoDTO;
import org.weather.dustApi.DustApiController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

@Slf4j
@Controller
@RequiredArgsConstructor
public class WeatherApiController {

    private final WeatherApiService weatherApiService;
    private final DustApiController dustApiController;

    @Value("${weather.api.key}")
    String weatherApiKey;

    @ResponseBody
    @PostMapping("/weatherRequest")
    public Map<String, Object> weatherRequest(WeatherareavoDTO weatherareavoDTO){

        String area = weatherareavoDTO.getArea();
        List<WeatherDataDTO> weatherDataDTOList = connectToWeatherApi(weatherareavoDTO);
            String weatherDataTime = weatherDataDTOList.get(0).getBaseTime().substring(0, 2);

        Map<String, Object> returnMap = new HashMap<>();
            returnMap.put("area", area);
            returnMap.put("weatherDataTime", weatherDataTime);
            returnMap.put("weatherDataDTOList", weatherDataDTOList);

        log.info("weatherRequest area: {}, weatherDataTime: {}시, weatherDataDTOList: {}", area, weatherDataTime, weatherDataDTOList);

        return returnMap;
    }

    @CrossOrigin(origins = "http://localhost:9001")
    @ResponseBody
    @PostMapping("/viewTodayWeather")
    public Map<String, Object> viewTodayWeather(WeatherareavoDTO weatherareavoDTO){

        String area = weatherareavoDTO.getArea();

        List<WeatherDataDTO> weatherDataDTOList = connectToWeatherApi(weatherareavoDTO);
        String weatherDataTime = weatherDataDTOList.get(0).getBaseTime().substring(0, 2);

        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("area", area);
        returnMap.put("weatherDataTime", weatherDataTime);
        returnMap.put("weatherDataDTOList", weatherDataDTOList);

        log.info("viewTodayWeather area: {}, weatherDataTime: {}시, weatherDataDTOList: {}", area, weatherDataTime, weatherDataDTOList);

        return returnMap;
    }

    @CrossOrigin(origins = "http://localhost:9001")
    @ResponseBody
    @PostMapping("/selectWeatherDataForQuestionToGPT")
    public List<Object> selectWeatherDataForQuestionToGPT(@RequestBody WeatherareavoDTO weatherareavoDTO) {
        List<WeatherDataDTO> weatherDataDTOList = connectToWeatherApi(weatherareavoDTO);
        List<WQ> wqList = new ArrayList<>();
        for(WeatherDataDTO weatherDataDTO : weatherDataDTOList){
            WQ wq = new WQ();
            BeanUtils.copyProperties(weatherDataDTO, wq);
            wqList.add(wq);
        }
        PQ pqList = dustApiController.selectDustDataForQuestionToGPT(weatherareavoDTO.getCountry(), weatherareavoDTO.getArea());
        List<Object> returnList = new ArrayList<>();
            returnList.add(pqList);
            returnList.add(wqList);
        return returnList;
    }

    private List<WeatherDataDTO> connectToWeatherApi(WeatherareavoDTO weatherareavoDTO){

        String area = weatherareavoDTO.getArea();

        //위도와 경도 가져오기
        Map position = weatherApiService.weatherRequest(area);
        List<WeatherDataDTO> weatherDataDTOList = new ArrayList<>();

        try {

            //api 요청을 위한 url 구성
            String stringURL =
                    "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst" +
                            "?serviceKey=" + weatherApiKey +
                            "&numOfRows=10" +
                            "&pageNo=1" +
                            "&dataType=JSON" +
                            "&base_date=" + weatherareavoDTO.getBase_date() +
                            "&base_time=" + weatherareavoDTO.getBase_time() +
                            "&nx="+ position.get("nx") +
                            "&ny="+ position.get("ny");

            //url로 HTTP Request
            URL url = new URL(stringURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            //응답코드 확인
            //log.info("Response Code: {}", connection.getResponseCode());

            //응답 처리
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String response = String.join("/n", bufferedReader.lines().toList());
            bufferedReader.close();
            connection.disconnect();

            //JSON 데이터 출력(원본)
            //log.info("Response: {}", response);

            //JSON 데이터에서 필요한 데이터 추출
            JSONObject jsonObject = new JSONObject(response);
            JSONObject items = jsonObject.getJSONObject("response").getJSONObject("body").getJSONObject("items");
            JSONArray itemsArray = items.getJSONArray("item");

            //DTO로 구성된 List 생성
            for (int i = 0; i < itemsArray.length(); i++) {
                JSONObject item = itemsArray.getJSONObject(i);
                String baseTime = item.getString("baseTime");
                String category = item.getString("category");
                String fcstValue = item.getString("fcstValue");

                //DTO 데이터 재구성
                WeatherDataDTO weatherDataDTO = new WeatherDataDTO();
                weatherDataDTO.setBaseTime(baseTime);
                weatherDataDTO.setCategory(category);
                weatherDataDTO.setFcstValue(category, fcstValue);
                weatherDataDTOList.add(weatherDataDTO);
            }
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }

        return weatherDataDTOList;
    }
}
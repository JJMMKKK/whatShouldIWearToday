package org.weather.api;

import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.weather.WeatherDataDTO;
import org.weather.WeatherareavoDTO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class WeatherApiController {

    private final WeatherApiService weatherApiService;

    private WeatherApiController(WeatherApiService weatherApiService){
        this.weatherApiService = weatherApiService;
    }

    @Value("${weather.api.key}")
    String weatherApiKey;

    @GetMapping("/")
    public String main(){
        return "Main";
    }

    @PostMapping("/weatherRequest")
    public ModelAndView weatherRequest(WeatherareavoDTO weatherareavoDTO){

        String area = weatherareavoDTO.getArea();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("area", area);

        //위도와 경도 가져오기
        Map position = weatherApiService.weatherRequest(area);

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
            List<WeatherDataDTO> weatherDataDTOList = new ArrayList<>();
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

            //가공된 데이터 출력
            //log.info("WeatherDataDTOList: {}", weatherDataDTOList);
            modelAndView.addObject("weatherDataDTOList", weatherDataDTOList);

        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }

        modelAndView.setViewName("Main");
        return modelAndView;
    }
}


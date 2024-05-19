package org.weather.dustApi;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.weather.place.PlaceDto;
import org.weather.place.PlaceService;
import org.weather.weatherApi.WeatherApiService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class DustApiController {

    private final DustApiService dustApiService;
    private final PlaceService placeService;
    private final WeatherApiService weatherApiService;

    @Value("${dust.api.key}")
    private String apiKey;

    @ResponseBody
    @PostMapping("/dustRequestAjax")
    public PaticulatemattervoDto dustRequestAjax(String country, String area) throws UnsupportedEncodingException {

        PlaceDto placeDto = placeService.findByCountryAndArea(country, area);
        if(placeDto == null){
            return new PaticulatemattervoDto();
        }
        return dustApiService.findByStationname(placeDto);
    }

    @CrossOrigin(origins = "http://localhost:9001")
    @ResponseBody
    @PostMapping("/viewTodayDust")
    public PaticulatemattervoDto viewTodayDust(String country, String area){
        PlaceDto placeDto = placeService.findByCountryAndArea(country, area);
        return dustApiService.findByStationname(placeDto);
    }

    //GPT 질문용
    public PQ selectDustDataForQuestionToGPT(String country, String area){
        PlaceDto placeDto = placeService.findByCountryAndArea(country, area);
        return dustApiService.selectDustDataForQuestionToGPT(placeDto);
    }

    @PostConstruct
    public void init()  throws IOException, JSONException {

//            List<String> encodedCounties = weatherApiService.findAllCountry();
//
//            for(String country : encodedCounties){
//
//                //Url 생성
//                String stringUrl =
//                        "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty" +
//                                "?sidoName=" + country +
//                                "&pageNo=" + "1" +
//                                "&numOfRows=" + "100" +
//                                "&returnType=" + "json" +
//                                "&serviceKey=" + apiKey +
//                                "&ver=" + "1.0";
//
//                //HTTP Request
//                URL url = new URL(stringUrl);
//                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//                connection.setRequestMethod("GET");
//
//                //응답코드 확인
//                //log.info("Response Code: {}", connection.getResponseCode());
//
//                //응답 처리
//                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//                String response = String.join("/n", bufferedReader.lines().toList());
//                bufferedReader.close();
//                connection.disconnect();
//
//                //JSON 데이터 출력
//                //log.info("Response: {}", response);
//
//                //JSON 데이터에서 필요한 데이터 추출
//                JSONObject jsonObject = new JSONObject(response);
//                JSONObject items = jsonObject.getJSONObject("response").getJSONObject("body");
//                JSONArray itemsArray = items.getJSONArray("items");
//
//                List<PaticulatemattervoDto> paticulateMatterList = new ArrayList<>();
//                for (int i = 0; i < itemsArray.length(); i++) {
//                    JSONObject item = itemsArray.getJSONObject(i);
//                    PaticulatemattervoDto paticulatemattervoDto = new PaticulatemattervoDto(
//                            item.getString("sidoName"), item.getString("dataTime"), item.getString("stationName"),
//                            item.getString("pm25Grade"), item.getString("pm25Flag"), item.getString("pm25Value"),
//                            item.getString("pm10Grade"), item.getString("pm10Flag"), item.getString("pm10Value")
//                    );
//                    paticulateMatterList.add(paticulatemattervoDto);
//                }
//
//                //List에 들어간 데이터 확인
//                //log.info("particulateMatterList: {}", paticulateMatterList.toString());
//
//                dustApiService.dustRequest(paticulateMatterList);
//
//            }

            String country = URLEncoder.encode("경기", StandardCharsets.UTF_8);

            //Url 생성
            String stringUrl =
                    "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty" +
                            "?sidoName=" + country +
                            "&pageNo=" + "1" +
                            "&numOfRows=" + "100" +
                            "&returnType=" + "json" +
                            "&serviceKey=" + apiKey +
                            "&ver=" + "1.0";

            //HTTP Request
            URL url = new URL(stringUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            //응답코드 확인
            //log.info("Response Code: {}", connection.getResponseCode());

            //응답 처리
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String response = String.join("/n", bufferedReader.lines().toList());
            bufferedReader.close();
            connection.disconnect();

            //JSON 데이터 출력
            //log.info("Response: {}", response);

            //JSON 데이터에서 필요한 데이터 추출
            JSONObject jsonObject = new JSONObject(response);
            JSONObject items = jsonObject.getJSONObject("response").getJSONObject("body");
            JSONArray itemsArray = items.getJSONArray("items");

            List<PaticulatemattervoDto> paticulateMatterList = new ArrayList<>();
            for (int i = 0; i < itemsArray.length(); i++) {
                JSONObject item = itemsArray.getJSONObject(i);
                PaticulatemattervoDto paticulatemattervoDto = new PaticulatemattervoDto(
                        item.getString("sidoName"), item.getString("dataTime"), item.getString("stationName"),
                        item.getString("pm25Grade"), item.getString("pm25Flag"), item.getString("pm25Value"),
                        item.getString("pm10Grade"), item.getString("pm10Flag"), item.getString("pm10Value")
                );
                paticulateMatterList.add(paticulatemattervoDto);
            }

            //List에 들어간 데이터 확인
            //log.info("particulateMatterList: {}", paticulateMatterList.toString());

            dustApiService.dustRequest(paticulateMatterList);

            log.info("DB에 "+"경기"+" 지역 미세먼지 데이터 저장 완료");
    }
}

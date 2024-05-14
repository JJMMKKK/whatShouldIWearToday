package org.weather.dustApi;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.weather.PaticulatemattervoDto;
import org.weather.PlaceDto;
import org.weather.place.PlaceService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class DustApiController {

    private final DustApiService dustApiService;
    private final PlaceService placeService;

    private DustApiController(DustApiService dustApiService, PlaceService placeService){
        this.dustApiService = dustApiService;
        this.placeService = placeService;
    }

    @Value("${dust.api.key}")
    private String apiKey;

    @GetMapping("/dustMain")
    public ModelAndView dustMain(){
        log.info("dustMain");
        String country = "경기";
        String area = "용인시수지구";
        PlaceDto placeDto = placeService.findByCountryAndArea(country, area);
        PaticulatemattervoDto paticulatemattervoDto = dustApiService.findByStationname(placeDto);
        ModelAndView mav = new ModelAndView("DustMain");
        mav.addObject("paticulatemattervoDto", paticulatemattervoDto);
        mav.addObject("area", area);
        return mav;
    }

    @RequestMapping("/dustRequest")
    public String dustRequest() throws IOException, JSONException {

            String country = "%EA%B2%BD%EA%B8%B0";  // 한글이 아스키코드로 변환되어야 함

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
                PaticulatemattervoDto paticulatemattervoDto = new PaticulatemattervoDto();
                paticulatemattervoDto.setSidoname(item.getString("sidoName"));
                paticulatemattervoDto.setDatatime(item.getString("dataTime"));
                paticulatemattervoDto.setStationname(item.getString("stationName"));
                paticulatemattervoDto.setPm25grade(item.getString("pm25Grade"));
                paticulatemattervoDto.setPm25flag(item.getString("pm25Flag"));
                paticulatemattervoDto.setPm25value(item.getString("pm25Value"));
                paticulatemattervoDto.setPm10grade(item.getString("pm10Grade"));
                paticulatemattervoDto.setPm10flag(item.getString("pm10Flag"));
                paticulatemattervoDto.setPm10value(item.getString("pm10Value"));
                paticulateMatterList.add(paticulatemattervoDto);
            }

            //List에 들어간 데이터 확인
            log.info("particulateMatterList: {}", paticulateMatterList.toString());

            dustApiService.dustRequest(paticulateMatterList);

        return "redirect:/dustMain";
    }


}

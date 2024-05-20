package org.weather.dustApi;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.weather.place.PlaceDto;
import org.weather.place.PlaceService;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class DustApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DustApiService dustApiService;

    @MockBean
    private PlaceService placeService;

    private String country;
    private String area;
    private String stationName;
    private PlaceDto placeDto;
    private PaticulatemattervoDto paticulatemattervoDto;

    private String notCountry;
    private String notArea;

    @BeforeEach
    void setUp() {
        country = "경기";
        area = "용인시수지구";
        stationName = "수지";
        notCountry = "CA";
        notArea = "San Francisco";
    }

    @Test
    void dustRequestAjax() throws Exception {

        // Given
        placeDto = new PlaceDto(country, area, stationName);
        paticulatemattervoDto = new PaticulatemattervoDto();
            paticulatemattervoDto.setStationname(stationName);
            paticulatemattervoDto.setSidoname(country);
            paticulatemattervoDto.setDatatime("2024-05-18 10:00");
            paticulatemattervoDto.setPm10grade("좋음");
            paticulatemattervoDto.setPm10value("50");
            paticulatemattervoDto.setPm25grade("보통");
            paticulatemattervoDto.setPm25value("25");

        given(placeService.findByCountryAndArea(country, area)).willReturn(placeDto);
        given(dustApiService.findByStationname(placeDto)).willReturn(paticulatemattervoDto);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
            map.add("country", country);
            map.add("area", area);

        // When & Then
        mockMvc
                .perform(
                        post("/dustRequestAjax").params(map)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.stationname").value(stationName))
                .andExpect(jsonPath("$.sidoname").value(country))
                .andExpect(jsonPath("$.datatime").value("2024-05-18 10:00"))
                .andExpect(jsonPath("$.pm10grade").value("좋음"))
                .andExpect(jsonPath("$.pm10value").value("50"))
                .andExpect(jsonPath("$.pm25grade").value("보통"))
                .andExpect(jsonPath("$.pm25value").value("25"));
    }

    @Test
    void notCountry_area_dustRequestAjax() throws Exception {
        // Given
        given(placeService.findByCountryAndArea(notCountry, area)).willReturn(null);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
            map.add("country", notCountry);
            map.add("area", area);

        // When & Then
        mockMvc
                .perform(
                        post("/dustRequestAjax").params(map)
                )
                .andExpect(status().isOk())
                .andExpect(content().json("{\"stationname\":null,\"sidoname\":null,\"datatime\":null,\"pm25grade\":null,\"pm25flag\":null,\"pm25value\":null,\"pm10grade\":null,\"pm10flag\":null,\"pm10value\":null}"));

    }

    @Test
    void country_notArea_dustRequestAjax() throws Exception {
        // Given
        given(placeService.findByCountryAndArea(country, notArea)).willReturn(null);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("country", country);
        map.add("area", notArea);

        // When & Then
        mockMvc
                .perform(
                        post("/dustRequestAjax").params(map)
                )
                .andExpect(status().isOk())
                .andExpect(content().json("{\"stationname\":null,\"sidoname\":null,\"datatime\":null,\"pm25grade\":null,\"pm25flag\":null,\"pm25value\":null,\"pm10grade\":null,\"pm10flag\":null,\"pm10value\":null}"));

    }

    @Test
    void notCountry_notArea_dustRequestAjax() throws Exception {
        // Given
        given(placeService.findByCountryAndArea(notCountry, notArea)).willReturn(null);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("country", notCountry);
        map.add("area", notArea);

        // When & Then
        mockMvc
                .perform(
                        post("/dustRequestAjax").params(map)
                )
                .andExpect(status().isOk())
                .andExpect(content().json("{\"stationname\":null,\"sidoname\":null,\"datatime\":null,\"pm25grade\":null,\"pm25flag\":null,\"pm25value\":null,\"pm10grade\":null,\"pm10flag\":null,\"pm10value\":null}"));

    }


}
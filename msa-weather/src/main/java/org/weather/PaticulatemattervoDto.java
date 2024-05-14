package org.weather;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link Paticulatemattervo}
 */
@Data
public class PaticulatemattervoDto implements Serializable {
    @NotNull
    @Size(max = 50)
    String sidoname;

    @NotNull
    @Size(max = 50)
    String datatime;

    @NotNull
    @Size(max = 50)
    String stationname;

    @Size(max = 50)
    String pm25grade;

    @Size(max = 50)
    String pm25flag;

    @Size(max = 50)
    String pm25value;

    @Size(max = 50)
    String pm10grade;

    @Size(max = 50)
    String pm10flag;

    @Size(max = 50)
    String pm10value;

    public void setPm25grade(String pm25grade) {
        this.pm25grade = switch (pm25grade){
            case "1", "좋음" -> "좋음";
            case "2", "보통" -> "보통";
            case "3", "나쁨" -> "나쁨";
            case "4", "매우나쁨" -> "매우나쁨";
            default -> "점검 중";
        };
    }

    public void setPm25value(String pm25value) {
        this.pm25value = pm25value + "㎍/㎥";
    }

    public void setPm10grade(String pm10grade) {
        this.pm10grade = switch (pm10grade){
            case "1", "좋음" -> "좋음";
            case "2", "보통" -> "보통";
            case "3", "나쁨" -> "나쁨";
            case "4", "매우나쁨" -> "매우나쁨";
            default -> "점검 중";
        };
    }

    public void setPm10value(String pm10value) {
        this.pm10value = pm10value + "㎍/㎥";
    }
}
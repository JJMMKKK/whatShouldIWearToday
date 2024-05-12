package org.weather;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link Weatherareavo}
 */
@Data
public class WeatherDataDTO implements Serializable {

    @NotNull
    String baseTime ;

    @NotNull
    String category;

    @NotNull
    String fcstValue;

    public void setCategory(String category){
        this.category = switch (category) {
            case "TMP" -> "1시간 기온";
            case "UUU" -> "풍속(동서성분)";
            case "VVV" -> "풍속(남북성분)";
            case "VEC" -> "풍향";
            case "WSD" -> "풍속";
            case "SKY" -> "하늘상태";
            case "PTY" -> "강수형태";
            case "POP" -> "강수확률";
            case "WAV" -> "파고";
            case "PCP" -> "1시간 강수량";
            default -> throw new IllegalStateException("Unexpected value: " + category);
        };
    };

    public void setFcstValue(String category, String fcstValue){
        this.fcstValue = switch (category) {
            case "TMP" -> fcstValue + "℃";
            case "UUU", "WSD", "VVV" -> fcstValue + "m/s";
            case "VEC" -> {
                            double value = Double.parseDouble(fcstValue);
                            double convertedValue = (value + 22.5 * 0.5) / 22.5;
                            int directionIndex = (int) Math.floor(convertedValue);
                            String[] directions = {"N", "NNE", "NE", "ENE", "E", "ESE", "SE", "SSE", "S", "SSW", "SW", "WSW", "W", "WNW", "NW", "NNW", "N"};
                            yield directions[directionIndex];
                          }
            case "SKY" -> {
                            int value = Integer.parseInt(fcstValue);
                            yield switch (value){
                                case 1, 2, 3, 4, 5 -> "맑음";
                                case 6, 7, 8 -> "구름많음";
                                case 9, 10 -> "흐림";
                                default -> throw new IllegalStateException("Unexpected value: " + value);
                            };
                          }
            case "PTY" -> { if (fcstValue.equals("0")) {
                                yield "강수없음";
                            } else {
                                yield fcstValue;
                            }}
            case "POP" -> fcstValue + "%";
            case "WAV" -> fcstValue + "M";
            case "PCP" -> { if (fcstValue.equals("강수없음")) {
                                yield fcstValue;
                            } else {
                                yield fcstValue + "mm";
                            }}
            default -> throw new IllegalStateException("Unexpected value: " + category);
        };
    }
}
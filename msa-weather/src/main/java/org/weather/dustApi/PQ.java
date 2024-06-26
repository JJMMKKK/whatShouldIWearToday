package org.weather.dustApi;

import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link Paticulatemattervo}
 */
@Data
public class PQ implements Serializable {

    @Size(max = 50)
    String pm25grade;

    @Size(max = 50)
    String pm25value;

    @Size(max = 50)
    String pm10grade;

    @Size(max = 50)
    String pm10value;
}
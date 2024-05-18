package org.weather.weatherApi;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link Weatherareavo}
 */
@Data
public class WQ implements Serializable {

    @NotNull
    String category;

    @NotNull
    String fcstValue;
}
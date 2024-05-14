package org.weather;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Weatherareavo}
 */
@Data
@Value
public class WeatherareavoDTO implements Serializable {

    @NotNull
    String base_date;

    @NotNull
    String base_time;

    @NotNull
    @Size(max = 50)
    String country;

    @NotNull
    @Size(max = 50)
    String area;
}
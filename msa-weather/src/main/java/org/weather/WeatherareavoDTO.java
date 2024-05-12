package org.weather;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Value;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

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
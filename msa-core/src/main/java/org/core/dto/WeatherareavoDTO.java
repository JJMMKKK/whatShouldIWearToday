package org.core.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

@Data
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
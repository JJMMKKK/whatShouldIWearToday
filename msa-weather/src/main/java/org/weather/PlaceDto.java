package org.weather;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Place}
 */
@Value
public class PlaceDto implements Serializable {

    @NotNull
    @Size(max = 50)
    String country;

    @Size(max = 50)
    String area;

    @NotNull
    @Size(max = 50)
    String stationName;

}
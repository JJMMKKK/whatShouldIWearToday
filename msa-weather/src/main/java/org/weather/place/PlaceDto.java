package org.weather.place;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Value;
import org.core.vo.Place;

import java.io.Serializable;

/**
 * DTO for {@link Place}
 */
@Data
public class PlaceDto implements Serializable {

    @NotNull
    @Size(max = 50)
    String country;

    @Size(max = 50)
    String area;

    @NotNull
    @Size(max = 50)
    String stationName;

    public PlaceDto(String country, String area, String stationName) {
        this.country = country;
        this.area = area;
        this.stationName = stationName;
    }

}
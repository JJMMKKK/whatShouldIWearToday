package org.weather;

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
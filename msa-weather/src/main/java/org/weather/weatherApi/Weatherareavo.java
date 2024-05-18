package org.weather.weatherApi;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "weatherareavo")
public class Weatherareavo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('weatherareavo_id_seq'")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "country", nullable = false, length = 50)
    private String country;

    @Size(max = 50)
    @NotNull
    @Column(name = "area", nullable = false, length = 50)
    private String area;

    @NotNull
    @Column(name = "nx", nullable = false)
    private Integer nx;

    @NotNull
    @Column(name = "ny", nullable = false)
    private Integer ny;

}
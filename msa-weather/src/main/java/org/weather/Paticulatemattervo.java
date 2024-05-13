package org.weather;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "paticulatemattervo")
public class Paticulatemattervo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('paticulatemattervo_id_seq'")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "sidoname", nullable = false, length = 50)
    private String sidoname;

    @Size(max = 50)
    @NotNull
    @Column(name = "datatime", nullable = false, length = 50)
    private String datatime;

    @Size(max = 50)
    @NotNull
    @Column(name = "stationname", nullable = false, length = 50)
    private String stationname;

    @Size(max = 50)
    @Column(name = "pm25grade", nullable = false, length = 50)
    private String pm25grade;

    @Size(max = 50)
    @Column(name = "pm25flag", length = 50)
    private String pm25flag;

    @Size(max = 50)
    @Column(name = "pm25value", length = 50)
    private String pm25value;

    @Size(max = 50)
    @Column(name = "pm10grade", nullable = false, length = 50)
    private String pm10grade;

    @Size(max = 50)
    @Column(name = "pm10flag", length = 50)
    private String pm10flag;

    @Size(max = 50)
    @Column(name = "pm10value", length = 50)
    private String pm10value;

}
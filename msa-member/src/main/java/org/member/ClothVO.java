package org.member;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "clothvo")
public class ClothVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('clothvo_clothid_seq'")
    @Column(name = "clothid", nullable = false)
    private Integer id;

    @Column(name = "userid")
    private Integer userid;

    @Size(max = 50)
    @NotNull
    @Column(name = "category", nullable = false, length = 50)
    private String category;

    @Size(max = 100)
    @NotNull
    @Column(name = "clothdata", nullable = false, length = 100)
    private String clothdata;

}
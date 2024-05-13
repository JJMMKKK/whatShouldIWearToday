package org.gpt;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "gptanswervo")
public class Gptanswervo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('gptanswervo_id_seq'")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Size(max = 50000)
    @NotNull
    @Column(name = "question", nullable = false, length = 50000)
    private String question;

    @Size(max = 50000)
    @NotNull
    @Column(name = "answer", nullable = false, length = 50000)
    private String answer;

}
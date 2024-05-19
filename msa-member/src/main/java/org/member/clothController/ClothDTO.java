package org.member.clothController;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link ClothVO}
 */
@Data
public class ClothDTO implements Serializable {

    @Id
    @NotNull
    Integer id;

    @NotNull
    Integer userid;

    @Size(max = 50)
    @NotBlank(message = "카테고리가 지정되어야 합니다.")
    String category;

    @Size(max = 100)
    @NotBlank(message = "옷이 입력되어야 합니다.")
    String clothdata;

}
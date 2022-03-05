package com.teamresourceful.editorbackend.dto.beedata.breeding;

import lombok.Data;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class BeeFamilyDto implements Serializable {
    @DecimalMin(value = "1.0", message = "Weight must be equal to or greater than 1.0!")
    @Digits(integer = 10, fraction = 3)
    private BigDecimal weight;
    @DecimalMin(value = "0.0", message = "Chance must be greater than 0.0!", inclusive = false)
    @DecimalMax(value = "1.0", message = "Chance must be less than or equal to 1.0!")
    @Digits(integer = 1, fraction = 3)
    private BigDecimal chance;
    private String parent1;
    private String parent2;
}

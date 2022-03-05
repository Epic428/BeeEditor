package com.teamresourceful.editorbackend.model.beedata.breeding;

import lombok.*;

import javax.persistence.Embeddable;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Embeddable
public class BeeFamily {

    @DecimalMin(value = "1.0", message = "Weight must be equal to or greater than 1.0!")
    @Digits(integer = 10, fraction = 3)
    private BigDecimal weight;
    @DecimalMin(value = "0.0", message = "Chance must be greater than 0.0!", inclusive = false)
    @DecimalMax(value = "1.0", message = "Chance must be less than or equal to 1.0!")
    @Digits(integer = 1, fraction = 3)
    private BigDecimal chance; //TODO Why is this not validating properly?? manually created and supplied bee is allowing value of 3 to go through
    private String parent1;
    private String parent2;

    @Builder
    public BeeFamily(BigDecimal weight, BigDecimal chance, String parent1, String parent2) {
        this.weight = weight;
        this.chance = chance;
        this.parent1 = parent1;
        this.parent2 = parent2;
    }
}
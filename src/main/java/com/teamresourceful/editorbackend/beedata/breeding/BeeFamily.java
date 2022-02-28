package com.teamresourceful.editorbackend.beedata.breeding;

import lombok.*;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Embeddable
public class BeeFamily {

    private BigDecimal weight;
    private BigDecimal chance;
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
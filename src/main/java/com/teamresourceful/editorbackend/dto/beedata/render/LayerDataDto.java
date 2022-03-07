package com.teamresourceful.editorbackend.dto.beedata.render;

import lombok.Data;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class LayerDataDto implements Serializable {
    private String color;
    private String texture;
    private Boolean isGlowing;
    private Boolean isEnchanted;
    private Boolean isPollen;
    //@Range(min = 5, max = 100, message = "Pulse frequency must be between 5 and 100 ticks!")
    @Min(value = 5, message = "Pulse frequency must be greater than or equal to 5!")
    @Max(value = 100, message = "Pulse frequency must be less than or equal to 100!")
    @Digits(integer = 3, fraction = 3)
    private BigDecimal pulseFrequency;
}

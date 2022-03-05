package com.teamresourceful.editorbackend.dto.beedata.render;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import java.io.Serializable;

@Data
public class LayerDataDto implements Serializable {
    private String color;
    private String texture;
    private Boolean isGlowing;
    private Boolean isEnchanted;
    private Boolean isPollen;
    @Range(min = 5, max = 100, message = "Pulse frequency must be between 5 and 100 ticks!")
    private Float pulseFrequency;
}

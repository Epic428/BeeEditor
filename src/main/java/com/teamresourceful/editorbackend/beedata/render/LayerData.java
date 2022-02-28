package com.teamresourceful.editorbackend.beedata.render;

import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Embeddable
public class LayerData {

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private String texture; // BeeTexture
    private Boolean isGlowing;
    private Boolean isEnchanted;
    private Boolean isPollen;
    @Range(min = 5, max = 100, message = "Pulse frequency must be between 5 and 100 ticks!")
    private Float pulseFrequency;

    @Builder
    public LayerData(String color, String texture, Boolean isGlowing, Boolean isEnchanted, Boolean isPollen, Float pulseFrequency) {
        this.color = color;
        this.texture = texture;
        this.isGlowing = isGlowing;
        this.isEnchanted = isEnchanted;
        this.isPollen = isPollen;
        this.pulseFrequency = pulseFrequency;
    }
}
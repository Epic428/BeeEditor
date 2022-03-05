package com.teamresourceful.editorbackend.model.beedata.trait;

import com.teamresourceful.editorbackend.utils.EditorUtils;
import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
@Embeddable
public class DamageEffect {

    @Pattern(message = EditorUtils.RL_ERROR_MSG, regexp = EditorUtils.RESOURCE_LOCATION)
    private String source;
    @Range(min = 0, max = 20, message = "Strength must be between 0 and 20 inclusively!")
    @Column(name = "de_strength")
    private Integer strength;
}
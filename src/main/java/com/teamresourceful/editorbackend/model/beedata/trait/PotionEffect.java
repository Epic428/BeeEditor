package com.teamresourceful.editorbackend.model.beedata.trait;

import com.teamresourceful.editorbackend.utils.EditorUtils;
import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Embeddable
public class PotionEffect {

    @Pattern(message = EditorUtils.RL_ERROR_MSG, regexp = EditorUtils.RESOURCE_LOCATION)
    private String effect;
    @Range(min = 0, max = 4, message = "Strength must be between 0 and 4, inclusively!")
    @Column(name = "pe_strength")
    private Integer strength;
}
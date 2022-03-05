package com.teamresourceful.editorbackend.model.beedata.trait;

import com.teamresourceful.editorbackend.utils.EditorUtils;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
@Embeddable
public class DamageType {

    @Pattern(message = EditorUtils.RL_ERROR_MSG, regexp = EditorUtils.RESOURCE_LOCATION)
    private String type;
    @Column(name = "amplifier")
    @Min(value = 1, message = "Amplifier must be greater than or equal to 1!")
    private Integer amplifier;
}
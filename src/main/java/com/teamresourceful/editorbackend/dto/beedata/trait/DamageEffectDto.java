package com.teamresourceful.editorbackend.dto.beedata.trait;

import com.teamresourceful.editorbackend.utils.EditorUtils;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
public class DamageEffectDto implements Serializable {
    @Pattern(message = EditorUtils.RL_ERROR_MSG, regexp = EditorUtils.RESOURCE_LOCATION)
    private String source;
    @Range(min = 0, max = 20, message = "Strength must be between 0 and 20 inclusively!")
    private Integer strength;
}

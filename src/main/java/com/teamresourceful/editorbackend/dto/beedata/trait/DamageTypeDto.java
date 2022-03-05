package com.teamresourceful.editorbackend.dto.beedata.trait;

import com.teamresourceful.editorbackend.utils.EditorUtils;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
public class DamageTypeDto implements Serializable {
    @Pattern(message = EditorUtils.RL_ERROR_MSG, regexp = EditorUtils.RESOURCE_LOCATION)
    private String type;
    @Min(value = 1, message = "Amplifier must be greater than or equal to 1!")
    private Integer amplifier;
}

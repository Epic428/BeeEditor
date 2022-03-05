package com.teamresourceful.editorbackend.dto;

import com.teamresourceful.editorbackend.utils.EditorUtils;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
public class ItemStackDto implements Serializable {
    @Pattern(message = EditorUtils.RL_ERROR_MSG, regexp = EditorUtils.RESOURCE_LOCATION)
    private String item;
    @Min(value = 1, message = "Item stack must have count equal to or greater than 1!.")
    private Integer count;
    private String nbt;
}

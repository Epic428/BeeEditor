package com.teamresourceful.editorbackend.dto.beedata.render;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class ColorDataDto implements Serializable {
    @NotNull(message = "Spawn egg primary color is required!")
    private String spawnEggPrimaryColor;
    @NotNull(message = "Spawn egg secondary color is required!")
    private String spawnEggSecondaryColor;
    @NotNull(message = "Jar color is required!")
    private String jarColor;
}

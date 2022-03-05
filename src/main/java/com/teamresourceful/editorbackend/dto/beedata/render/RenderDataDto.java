package com.teamresourceful.editorbackend.dto.beedata.render;

import com.teamresourceful.editorbackend.utils.EditorUtils;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Data
public class RenderDataDto implements Serializable {
    @NotNull(message = "Layer data is required!")
    private Set<LayerDataDto> layerData;
    @NotNull(message = "Color data is required!")
    private ColorDataDto colorData;
    @NotNull(message = "Model is required!")
    @Pattern(message = EditorUtils.RL_ERROR_MSG, regexp = EditorUtils.RESOURCE_LOCATION)
    private String model;
    @NotNull(message = "Texture is required!")
    private String texture;
    @Pattern(message = EditorUtils.RL_ERROR_MSG, regexp = EditorUtils.RESOURCE_LOCATION)
    private String animation;
    @DecimalMin(value = "0.5", message = "Size modifier must be greater than or equal to 0.5")
    @DecimalMax(value = "2.0", message = "Size modifier must be less than or equal to 2.0")
    @Digits(integer = 1, fraction = 10)
    private BigDecimal sizeModifier;
}

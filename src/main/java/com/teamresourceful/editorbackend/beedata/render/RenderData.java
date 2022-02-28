package com.teamresourceful.editorbackend.beedata.render;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.teamresourceful.editorbackend.beedata.CustomBeeData;
import com.teamresourceful.editorbackend.utils.EditorUtils;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "render_data")
public class RenderData {

    @Id
    @Column(name = "bee_id")
    @JsonIgnore
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "bee_id")
    @JsonIgnore
    private CustomBeeData beeData;

    @ElementCollection
    @CollectionTable(name = "layer_data", joinColumns = @JoinColumn(name = "bee_id"))
    @Column(name = "layer", nullable = false)
    @JsonProperty("layers")
    private Set<LayerData> layerData = new LinkedHashSet<>(); //needs to have order preserved due to being converted to a LinkedHashSet in mod

    @Embedded
    @Column(nullable = false)
    private ColorData colorData;

    @Column(nullable = false)
    @Pattern(message = EditorUtils.RL_ERROR_MSG, regexp = EditorUtils.RESOURCE_LOCATION)
    private String model; //ResourceLocation in mod

    @Column(nullable = false)
    private String texture; //BeeTexture

    @Pattern(message = EditorUtils.RL_ERROR_MSG, regexp = EditorUtils.RESOURCE_LOCATION)
    private String animation; //ResourceLocation in mod

    @DecimalMin(value = "0.5", message = "Size modifier must be greater than or equal to 0.5")
    @DecimalMax(value = "2.0", message = "Size modifier must be less than or equal to 2.0")
    @Digits(integer = 1, fraction = 10)
    //@Range(min = 1, max = 2, message = "Size modifier must be between 1.0 and 2.0!")
    private BigDecimal sizeModifier;

    @Builder
    public RenderData(Set<LayerData> layerData, ColorData colorData, String model, String texture, String animation, BigDecimal sizeModifier) {
        this.layerData = layerData;
        this.colorData = colorData;
        this.model = model;
        this.texture = texture;
        this.animation = animation;
        this.sizeModifier = sizeModifier;
    }
}
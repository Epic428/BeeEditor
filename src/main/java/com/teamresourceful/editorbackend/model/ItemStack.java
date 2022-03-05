package com.teamresourceful.editorbackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.teamresourceful.editorbackend.utils.EditorUtils;
import lombok.*;

import javax.persistence.Embeddable;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Embeddable
public class ItemStack {

    @JsonProperty(namespace = "id")
    @Pattern(message = EditorUtils.RL_ERROR_MSG, regexp = EditorUtils.RESOURCE_LOCATION)
    private String item;
    //@Range(min = 1, max = 64, message = "Item stacks must have a count between 1 and 64, inclusively!")
    // I really probably should make it a range between 1 and 64 but there's some use cases for greater than 64
    @Min(value = 1, message = "Item stack must have count equal to or greater than 1!.")
    private Integer count;
    private String nbt;
}
package com.teamresourceful.editorbackend.dto.beedata;

import com.teamresourceful.editorbackend.utils.EditorUtils;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
public class CoreDataDto implements Serializable {
    @NotNull
    private String name;
    private Set<@Pattern(message = EditorUtils.RL_ERROR_MSG, regexp = EditorUtils.RESOURCE_LOCATION) String> flower;
    @Pattern(message = EditorUtils.RL_ERROR_MSG, regexp = EditorUtils.RESOURCE_LOCATION)
    private String entityFlower;
    @Min(value = 600, message = "Max time in hive must be greater than or equal to 600 ticks!")
    private Integer maxTimeInHive;
    @Range(min = 3, max = 20, message = "Aura range must be between 3 and 20!")
    private Integer auraRange;
    private List<String> lore;
}

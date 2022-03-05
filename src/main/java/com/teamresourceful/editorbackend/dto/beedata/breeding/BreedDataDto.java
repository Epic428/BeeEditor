package com.teamresourceful.editorbackend.dto.beedata.breeding;

import com.teamresourceful.editorbackend.dto.ItemStackDto;
import com.teamresourceful.editorbackend.utils.EditorUtils;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Set;

@Data
public class BreedDataDto implements Serializable {
    private Set<BeeFamilyDto> parents;
    private Set<@Pattern(message = EditorUtils.RL_ERROR_MSG, regexp = EditorUtils.RESOURCE_LOCATION)String> feedItem;
    private ItemStackDto feedReturnItem;
    @Min(value = 1, message = "Feed Amount must be greater than or equal to 1!")
    private Integer feedAmount;
    @Min(value = 1, message = "Child growth delay must be greater than or equal to 1!")
    private Integer childGrowthDelay;
    @Min(value = 1, message = "Breed delay must be greater than or equal to 1!")
    private Integer breedDelay;
}

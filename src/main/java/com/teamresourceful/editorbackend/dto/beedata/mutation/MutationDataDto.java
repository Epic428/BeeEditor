package com.teamresourceful.editorbackend.dto.beedata.mutation;

import lombok.Data;

import javax.validation.constraints.Min;
import java.io.Serializable;

@Data
public class MutationDataDto implements Serializable {
    @Min(value = 1, message = "Mutation count must be equal to or greater than 1!")
    private Integer mutationCount;
}

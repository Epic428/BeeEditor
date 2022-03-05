package com.teamresourceful.editorbackend.model.beedata.mutation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teamresourceful.editorbackend.model.beedata.BeeData;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "mutation_data")
public class MutationData {

    @Id
    @Column(name = "bee_id")
    @JsonIgnore
    private UUID id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "bee_id")
    @JsonIgnore
    private BeeData beeData;
    @Min(value = 1, message = "Mutation count must be equal to or greater than 1!")
    private Integer mutationCount;

    //TODO add mutation stuff after determining the json format

    @Builder
    public MutationData(Integer mutationCount) {
        this.mutationCount = mutationCount;
    }
}
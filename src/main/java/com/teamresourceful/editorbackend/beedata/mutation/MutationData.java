package com.teamresourceful.editorbackend.beedata.mutation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teamresourceful.editorbackend.beedata.CustomBeeData;
import lombok.*;

import javax.persistence.*;

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
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "bee_id")
    @JsonIgnore
    private CustomBeeData beeData;

    private Integer mutationCount;

    //TODO add mutation stuff after determining the json format

    @Builder
    public MutationData(Integer mutationCount) {
        this.mutationCount = mutationCount;
    }
}
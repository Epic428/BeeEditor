package com.teamresourceful.editorbackend.beedata.breeding;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.teamresourceful.editorbackend.beedata.CustomBeeData;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "breed_data")
public class BreedData {

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
    @CollectionTable(name = "bee_families", joinColumns = @JoinColumn(name = "bee_id"))
    @Column(name = "family", nullable = false)
    @JsonProperty("parents")
    private Set<BeeFamily> parents = new HashSet<>();

    private String feedItem; //uses TODO item holder codec. need to break down to primitive data types
    private String feedReturnItem; //uses TODO ItemStack codec need to break down further to primitive data types

    private Integer feedAmount;
    private Integer childGrowthDelay;
    private Integer breedDelay;

    @Builder
    public BreedData(Set<BeeFamily> parents, String feedItem, String feedReturnItem, Integer feedAmount, Integer childGrowthDelay, Integer breedDelay) {
        this.parents = parents;
        this.feedItem = feedItem;
        this.feedReturnItem = feedReturnItem;
        this.feedAmount = feedAmount;
        this.childGrowthDelay = childGrowthDelay;
        this.breedDelay = breedDelay;
    }
}
package com.teamresourceful.editorbackend.model.beedata.breeding;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.teamresourceful.editorbackend.model.ItemStack;
import com.teamresourceful.editorbackend.model.beedata.BeeData;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

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
    private UUID id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "bee_id")
    @JsonIgnore
    private BeeData beeData;

    @ElementCollection
    @CollectionTable(name = "bee_families", joinColumns = @JoinColumn(name = "bee_id"))
    @Column(name = "family", nullable = false)
    @JsonProperty("parents")
    private Set<BeeFamily> parents = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "feed_items", joinColumns = @JoinColumn(name = "bee_id"))
    @Column(name = "item", nullable = false)
    private Set<String> feedItem;

    @Embedded
    private ItemStack feedReturnItem;

    //@Range(min = 1, max = 64, message = "Feed Amount must be between 1 and 64!")
    @Min(value = 1, message = "Feed Amount must be greater than or equal to 1!")
    private Integer feedAmount;
    @Min(value = 1, message = "Child growth delay must be greater than or equal to 1!")
    private Integer childGrowthDelay;
    @Min(value = 1, message = "Breed delay must be greater than or equal to 1!")
    private Integer breedDelay;

    @Builder
    public BreedData(Set<BeeFamily> parents, Set<String> feedItem, ItemStack feedReturnItem, Integer feedAmount, Integer childGrowthDelay, Integer breedDelay) {
        this.parents = parents;
        this.feedItem = feedItem;
        this.feedReturnItem = feedReturnItem;
        this.feedAmount = feedAmount;
        this.childGrowthDelay = childGrowthDelay;
        this.breedDelay = breedDelay;
    }
}
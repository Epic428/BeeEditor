package com.teamresourceful.editorbackend.beedata;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teamresourceful.editorbackend.utils.EditorUtils;
import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "core_data")
public class CoreData {

    @Id
    @Column(name = "bee_id")
    @JsonIgnore
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "bee_id")
    @JsonIgnore
    private CustomBeeData beeData;

    @Column(nullable = false)
    private String name;

    @ElementCollection
    @CollectionTable(name = "flowers", joinColumns = @JoinColumn(name = "bee_id"))
    @Column(name = "flower")
    //TODO figure out why validation isn't running.....
    private Set<@Pattern(message = EditorUtils.RL_ERROR_MSG, regexp = EditorUtils.RESOURCE_LOCATION) String> flower = new LinkedHashSet<>();
    //TODO figure out how --> value *should* be either single string or list of strings.

    @Column(name = "entityFlower")
    @Pattern(message = EditorUtils.RL_ERROR_MSG, regexp = EditorUtils.RESOURCE_LOCATION)
    private String entityFlower;

    @Min(value = 600, message = "Max time in hive must be greater than or equal to 600 ticks!")
    @Column(name = "maxTimeInHive")
    private Integer maxTimeInHive;

    @Column(name = "auraRange")
    @Range(min = 3, max = 20, message = "Aura range must be between 3 and 20!")
    private Integer auraRange;

    @ElementCollection
    @CollectionTable(name = "lore", joinColumns = @JoinColumn(name = "bee_id"))
    private List<String> lore = new LinkedList<>();

    @Builder
    public CoreData(String name, Set<String> flower, String entityFlower, Integer maxTimeInHive, Integer auraRange, List<String> lore) {
        this.name = name;
        this.flower = flower;
        this.entityFlower = entityFlower;
        this.maxTimeInHive = maxTimeInHive;
        this.auraRange = auraRange;
        this.lore = lore;
    }
}
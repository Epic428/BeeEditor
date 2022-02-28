package com.teamresourceful.editorbackend.beedata.breeding;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.teamresourceful.editorbackend.beedata.CustomBeeData;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//@Embeddable
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

    public BreedData() {
    }

    public BreedData(Set<BeeFamily> parents, String feedItem, String feedReturnItem, Integer feedAmount, Integer childGrowthDelay, Integer breedDelay) {
        this.parents = parents;
        this.feedItem = feedItem;
        this.feedReturnItem = feedReturnItem;
        this.feedAmount = feedAmount;
        this.childGrowthDelay = childGrowthDelay;
        this.breedDelay = breedDelay;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomBeeData getBeeData() {
        return beeData;
    }

    public void setBeeData(CustomBeeData beeData) {
        this.beeData = beeData;
    }

    public Set<BeeFamily> getParents() {
        return parents;
    }

    public void setParents(Set<BeeFamily> parents) {
        this.parents = parents;
    }

    public String getFeedItem() {
        return feedItem;
    }

    public void setFeedItem(String feedItem) {
        this.feedItem = feedItem;
    }

    public String getFeedReturnItem() {
        return feedReturnItem;
    }

    public void setFeedReturnItem(String feedReturnItem) {
        this.feedReturnItem = feedReturnItem;
    }

    public Integer getFeedAmount() {
        return feedAmount;
    }

    public void setFeedAmount(Integer feedAmount) {
        this.feedAmount = feedAmount;
    }

    public Integer getChildGrowthDelay() {
        return childGrowthDelay;
    }

    public void setChildGrowthDelay(Integer childGrowthDelay) {
        this.childGrowthDelay = childGrowthDelay;
    }

    public Integer getBreedDelay() {
        return breedDelay;
    }

    public void setBreedDelay(Integer breedDelay) {
        this.breedDelay = breedDelay;
    }

    @Override
    public String toString() {
        return "BreedData{" +
                "parents=" + parents +
                ", feedItem='" + feedItem + '\'' +
                ", feedReturnItem='" + feedReturnItem + '\'' +
                ", feedAmount=" + feedAmount +
                ", childGrowthDelay=" + childGrowthDelay +
                ", breedDelay=" + breedDelay +
                '}';
    }


}
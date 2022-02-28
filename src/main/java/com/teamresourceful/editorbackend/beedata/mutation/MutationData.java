package com.teamresourceful.editorbackend.beedata.mutation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teamresourceful.editorbackend.beedata.CustomBeeData;

import javax.persistence.*;

//@Embeddable
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


    public MutationData() {
    }

    public MutationData(Integer mutationCount) {
        this.mutationCount = mutationCount;
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

    public Integer getMutationCount() {
        return mutationCount;
    }

    public void setMutationCount(Integer mutationCount) {
        this.mutationCount = mutationCount;
    }

    @Override
    public String toString() {
        return "MutationData{" +
                "mutationCount=" + mutationCount +
                '}';
    }
}
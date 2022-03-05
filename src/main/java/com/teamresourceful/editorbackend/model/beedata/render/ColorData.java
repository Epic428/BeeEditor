package com.teamresourceful.editorbackend.model.beedata.render;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Embeddable
public class ColorData {

    //TODO figure out how to handle data validation since values can be either an integer or a string

    @Column(nullable = false)
    private String spawnEggPrimaryColor ;
    @Column(nullable = false)
    private String spawnEggSecondaryColor;
    @Column(nullable = false)
    private String jarColor;

    public ColorData(String spawnEggPrimaryColor, String spawnEggSecondaryColor, String jarColor) {
        this.spawnEggPrimaryColor = spawnEggPrimaryColor;
        this.spawnEggSecondaryColor = spawnEggSecondaryColor;
        this.jarColor = jarColor;
    }
}
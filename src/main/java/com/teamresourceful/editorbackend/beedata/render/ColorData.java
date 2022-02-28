package com.teamresourceful.editorbackend.beedata.render;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ColorData {

    //TODO figure out how to handle data validation since values can be a variety of options

    @Column(nullable = false)
    private String spawnEggPrimaryColor ;
    @Column(nullable = false)
    private String spawnEggSecondaryColor;
    @Column(nullable = false)
    private String jarColor;

    public ColorData() {
    }

    public ColorData(String spawnEggPrimaryColor, String spawnEggSecondaryColor, String jarColor) {
        this.spawnEggPrimaryColor = spawnEggPrimaryColor;
        this.spawnEggSecondaryColor = spawnEggSecondaryColor;
        this.jarColor = jarColor;
    }

    public String getSpawnEggPrimaryColor() {
        return spawnEggPrimaryColor;
    }

    public void setSpawnEggPrimaryColor(String spawnEggPrimaryColor) {
        this.spawnEggPrimaryColor = spawnEggPrimaryColor;
    }

    public String getSpawnEggSecondaryColor() {
        return spawnEggSecondaryColor;
    }

    public void setSpawnEggSecondaryColor(String spawnEggSecondaryColor) {
        this.spawnEggSecondaryColor = spawnEggSecondaryColor;
    }

    public String getJarColor() {
        return jarColor;
    }

    public void setJarColor(String jarColor) {
        this.jarColor = jarColor;
    }

    @Override
    public String toString() {
        return "ColorData{" +
                "spawnEggPrimaryColor='" + spawnEggPrimaryColor + '\'' +
                ", spawnEggSecondaryColor='" + spawnEggSecondaryColor + '\'' +
                ", jarColor='" + jarColor + '\'' +
                '}';
    }
}
package com.teamresourceful.editorbackend.beedata.trait;

import lombok.*;

import javax.persistence.Embeddable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Embeddable
public class PotionEffect {

    private String effect;
    private Integer strength;
}
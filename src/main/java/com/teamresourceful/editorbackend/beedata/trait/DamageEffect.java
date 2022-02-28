package com.teamresourceful.editorbackend.beedata.trait;

import lombok.*;

import javax.persistence.Embeddable;

@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
@Embeddable
public class DamageEffect {

    private String source;
    private Integer str; //TODO when named as Strength this column clashes with the one in PotionEffect - fix this!
}
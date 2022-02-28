package com.teamresourceful.editorbackend.beedata.trait;

import lombok.*;

import javax.persistence.Embeddable;

@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
@Embeddable
public class DamageType {

    private String type;
    private Integer amplifier;
}
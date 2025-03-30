package com.will.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Grass extends Entity {

    private int remainingBites = 3;
    private String sign = "\uD83C\uDF40";

    @Override
    public String getClassName() {
        return Grass.class.getSimpleName();
    }
}

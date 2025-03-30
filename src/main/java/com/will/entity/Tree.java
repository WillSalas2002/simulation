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
public class Tree extends Entity {

    private String sign = "\uD83C\uDF33";

    @Override
    public String getClassName() {
        return Tree.class.getSimpleName();
    }
}

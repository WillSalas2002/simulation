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
public class Rock extends Entity {

    private String sign = "\uD83D\uDC8E";

    @Override
    public String getClassName() {
        return Rock.class.getSimpleName();
    }
}

package com.will.entity;

import com.will.Coordinate;
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

    public Grass(Coordinate coordinate) {
        super(coordinate);
    }
}

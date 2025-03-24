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
public class Tree extends Entity {

    public Tree(Coordinate coordinate) {
        super(coordinate);
    }
}

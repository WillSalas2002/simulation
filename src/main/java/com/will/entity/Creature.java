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
public abstract class Creature extends Entity {

    protected int hp = 100;
    protected int velocity = 1;
    protected boolean isTargetNear;

    public Creature(Coordinate coordinate) {
        super(coordinate);
    }

    public Creature(Coordinate coordinate, int hp, int velocity) {
        super(coordinate);
        this.hp = hp;
        this.velocity = velocity;
    }

    protected abstract void makeMove(Coordinate coordinate);
}

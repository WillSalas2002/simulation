package com.will.entity;

import com.will.Coordinate;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Herbivore extends Creature {

    public Herbivore(Coordinate coordinate) {
        super(coordinate);
    }

    public Herbivore(Coordinate coordinate, int hp, int velocity) {
        super(coordinate, hp, velocity);
    }

    @Override
    public void makeMove(Coordinate coordinate) {
        if (isTargetNear) {
            System.out.println("Eat Grass");
        } else {
            System.out.println("Make move towards grass");
        }
    }
}

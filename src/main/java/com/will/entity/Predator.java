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
public class Predator extends Creature {

    private int strength = 20;

    public Predator(Coordinate coordinate) {
        super(coordinate);
    }

    public Predator(Coordinate coordinate, int hp, int velocity, int strength) {
        super(coordinate, hp, velocity);
        this.strength = strength;
    }

    @Override
    public void makeMove(Coordinate coordinate) {
        if (isTargetNear) {
            System.out.println("Eat Herbivore at coordinate " + coordinate);
        } else {
            System.out.println("Make move towards Herbivore");
        }
    }
}

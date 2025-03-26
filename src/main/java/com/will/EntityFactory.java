package com.will;

import com.will.entity.Entity;
import com.will.entity.Grass;
import com.will.entity.Herbivore;
import com.will.entity.Predator;
import com.will.entity.Rock;
import com.will.entity.Tree;

public class EntityFactory {

    public static Entity createEntity(EntityType type) {
        return switch (type) {
            case GRASS -> new Grass();
            case HERBIVORE -> new Herbivore();
            case PREDATOR -> new Predator();
            case ROCK -> new Rock();
            case TREE -> new Tree();
        };
    }

    public enum EntityType {
        GRASS,
        HERBIVORE,
        PREDATOR,
        ROCK,
        TREE
    }
}

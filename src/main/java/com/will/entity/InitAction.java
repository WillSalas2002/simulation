package com.will.entity;

import com.will.Action;
import com.will.Coordinate;
import com.will.GameMap;

import java.util.Random;

public class InitAction implements Action {

    private static final Random RANDOM = new Random();
    private Entity[] entities = {new Rock(), new Grass(), new Tree(), new Herbivore(), new Predator()};

    @Override
    public void doWork(GameMap gameMap) {
        int randomInt = RANDOM.nextInt(entities.length);
        Entity randomEntity = entities[randomInt];
        int randomX = RANDOM.nextInt(gameMap.getX());
        int randomY = RANDOM.nextInt(gameMap.getY());
        randomEntity.setCoordinate(new Coordinate(randomX, randomY));
    }
}

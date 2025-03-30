package com.will.action;

import com.will.Coordinate;
import com.will.GameMap;
import com.will.entity.Entity;

import java.util.Random;

import static com.will.EntityFactory.EntityType.values;
import static com.will.EntityFactory.createEntity;

public class InitAction implements Action {

    private static final Random RANDOM = new Random();
    private static final int PERCENTAGE_RATE = 100;

    private final GameMap gameMap;
    private final int initialCapacity;

    public InitAction(GameMap gameMap, int initialCapacity) {
        this.gameMap = gameMap;
        this.initialCapacity = initialCapacity;
    }

    @Override
    public void doWork() {
        int quantityOfEntitiesToBeSpawn = (gameMap.getX() * gameMap.getY()) * initialCapacity / PERCENTAGE_RATE;

        for (int i = 0; i < quantityOfEntitiesToBeSpawn; i++) {
            Entity randomEntity = getRandomEntity();
            Coordinate coordinate = getRandomEmptyCellInMap(gameMap);

            randomEntity.setCoordinate(coordinate);
            gameMap.placeEntity(coordinate, randomEntity);
        }
    }

    private Coordinate getRandomEmptyCellInMap(GameMap gameMap) {
        int randomX = RANDOM.nextInt(gameMap.getX());
        int randomY = RANDOM.nextInt(gameMap.getY());

        Coordinate coordinate = new Coordinate(randomX, randomY);
        while (!gameMap.isEmpty(coordinate)) {
            coordinate = new Coordinate(RANDOM.nextInt(gameMap.getX()), RANDOM.nextInt(gameMap.getY()));
        }
        return coordinate;
    }

    private Entity getRandomEntity() {
        int randomInt = RANDOM.nextInt(values().length);
        return createEntity(values()[randomInt]);
    }
}

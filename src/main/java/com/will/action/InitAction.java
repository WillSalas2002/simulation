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

    private final int xLength;
    private final int yLength;
    private final int initialCapacity;

    public InitAction(int xLength, int yLength, int initialCapacity) {
        this.initialCapacity = initialCapacity;
        this.xLength = xLength;
        this.yLength = yLength;
    }

    @Override
    public void doWork(GameMap gameMap) {
        int quantityOfEntitiesToBeSpawn = (xLength * yLength) * initialCapacity / PERCENTAGE_RATE;

        for (int i = 0; i < quantityOfEntitiesToBeSpawn; i++) {
            Entity randomEntity = getRandomEntity();
            Coordinate coordinate = getRandomEmptyCellInMap(gameMap);

            randomEntity.setCoordinate(coordinate);
            gameMap.placeEntity(coordinate, randomEntity);
        }
    }

    private Coordinate getRandomEmptyCellInMap(GameMap gameMap) {
        int randomX = RANDOM.nextInt(xLength);
        int randomY = RANDOM.nextInt(yLength);

        Coordinate coordinate = new Coordinate(randomX, randomY);
        while (!gameMap.isEmpty(coordinate)) {
            coordinate = new Coordinate(RANDOM.nextInt(xLength), RANDOM.nextInt(yLength));
        }
        return coordinate;
    }

    private Entity getRandomEntity() {
        int randomInt = RANDOM.nextInt(values().length);
        return createEntity(values()[randomInt]);
    }
}

package com.will;

import com.will.entity.Entity;
import com.will.entity.Grass;
import com.will.entity.Herbivore;
import com.will.entity.Predator;
import com.will.entity.Rock;
import com.will.entity.Tree;

import java.util.Random;

public class InitAction implements Action {

    private static final Random RANDOM = new Random();
    private final Entity[] entities = {new Rock(), new Grass(), new Tree(), new Herbivore(), new Predator()};

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
        int quantityOfEntitiesToBeSpawn = (xLength * yLength) * initialCapacity / 100;
        for (int i = 0; i < quantityOfEntitiesToBeSpawn; i++) {

            Entity randomEntity = getRandomEntity();

            int randomX = RANDOM.nextInt(xLength);
            int randomY = RANDOM.nextInt(yLength);
            Coordinate coordinate = new Coordinate(randomX, randomY);

            while (!gameMap.isEmpty(coordinate)) {
                coordinate = new Coordinate(RANDOM.nextInt(xLength), RANDOM.nextInt(yLength));
            }
            randomEntity.setCoordinate(coordinate);
            gameMap.placeEntity(coordinate, randomEntity);
        }
    }

    private Entity getRandomEntity() {
        int randomInt = RANDOM.nextInt(entities.length);
        return entities[randomInt];
    }
}

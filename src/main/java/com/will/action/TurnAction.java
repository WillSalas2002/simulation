package com.will.action;

import com.will.Coordinate;
import com.will.GameMap;
import com.will.entity.Creature;

public class TurnAction implements Action {

    @Override
    public void doWork(GameMap gameMap) {
        for (Coordinate coordinate : gameMap.findAllCoordinates()) {
            if (gameMap.getEntityByCoordinate(coordinate) instanceof Creature creature) {
                creature.makeMove(coordinate);
            }
        }
    }
}

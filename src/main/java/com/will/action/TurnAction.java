package com.will.action;

import com.will.Coordinate;
import com.will.GameMap;
import com.will.entity.Creature;
import com.will.search.BreadthFirstSearch;
import com.will.search.PathFinder;

import java.util.ArrayList;
import java.util.List;

public class TurnAction implements Action {

    private final PathFinder pathFinder;
    private final GameMap gameMap;

    public TurnAction(GameMap gameMap) {
        this.gameMap = gameMap;
        pathFinder = new BreadthFirstSearch(gameMap);
    }

    @Override
    public void doWork() {
        List<Coordinate> originalMap = gameMap.findAllCoordinates();
        List<Coordinate> cloneMap = new ArrayList<>(gameMap.findAllCoordinates());
        for (int i = 0; i < cloneMap.size(); i++) {
            if (gameMap.getEntityByCoordinate(originalMap.get(i)) instanceof Creature creature) {
                creature.makeMove(gameMap, pathFinder);
            }
        }
    }
}

package com.will;

import com.will.action.Action;
import com.will.action.InitAction;
import com.will.action.TurnAction;
import com.will.entity.Grass;
import com.will.entity.Herbivore;
import com.will.entity.Predator;
import com.will.entity.Rock;
import com.will.entity.Tree;

import java.util.List;

public class Simulation {

    public static final int DEFAULT_INITIAL_CAPACITY = 20;

    private volatile boolean isStopped;
    private final GameMap gameMap;
    private int counter;
    private final MapRenderer mapRenderer;
    private final List<Action> actions;

    public Simulation(GameMap gameMap, MapRenderer mapRenderer) {
        this.gameMap = gameMap;
        this.mapRenderer = mapRenderer;
        this.actions = List.of(
                new InitAction(gameMap, DEFAULT_INITIAL_CAPACITY),
                new TurnAction(gameMap)
        );
    }

    public void start() {
        actions.get(0).doWork();
        while (!isStopped) {
            nextTurn();
        }
    }

    public void nextTurn() {
        System.out.println("Amount: " + gameMap.getQuantityOfEntities());
        System.out.println("Grass: " + gameMap.getByType(Grass.class).size());
        System.out.println("Herbivore: " + gameMap.getByType(Herbivore.class).size());
        System.out.println("Predator: " + gameMap.getByType(Predator.class).size());
        System.out.println("Tree: " + gameMap.getByType(Tree.class).size());
        System.out.println("Rock: " + gameMap.getByType(Rock.class).size());
        mapRenderer.render(gameMap);
        actions.get(1).doWork();
        counter++;
    }

    public void pause() {
        Thread thread = new Thread(() -> isStopped = true);
        thread.start();
    }
}

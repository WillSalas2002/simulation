package com.will;

import java.util.List;

public class Simulation {

    public static final int DEFAULT_INITIAL_CAPACITY = 50;

    private volatile boolean isStopped;
    private final GameMap gameMap;
    private int counter;
    private final MapRenderer mapRenderer;
    private final List<Action> actions;

    public Simulation(GameMap gameMap, MapRenderer mapRenderer) {
        this.gameMap = gameMap;
        this.mapRenderer = mapRenderer;
        this.actions = List.of(
                new InitAction(gameMap.getX(), gameMap.getY(), DEFAULT_INITIAL_CAPACITY),
                new TurnAction()
        );
    }

    public void start() {
        actions.get(0).doWork(gameMap);
        System.out.println("Amount: " + gameMap.getQuantityOfEntities());
        while (!isStopped) {
            nextTurn();
        }
    }

    public void nextTurn() {
        mapRenderer.render(gameMap);
        actions.get(1).doWork(gameMap);
        counter++;
    }

    public void pause() {
        Thread thread = new Thread(() -> {
            isStopped = true;
        });
        thread.start();
    }
}

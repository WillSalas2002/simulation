package com.will;

public class App {
    public static void main(String[] args) {

        GameMap gameMap = new GameMap(10, 10);
        MapRenderer mapRenderer = new MapRenderer(gameMap.getX(), gameMap.getY());
        Simulation simulation = new Simulation(gameMap, mapRenderer);
        simulation.start();
    }
}

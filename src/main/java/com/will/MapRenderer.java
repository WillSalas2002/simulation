package com.will;

import com.will.entity.Entity;

import java.util.Map;

public class MapRenderer {

    private final int X;
    private final int Y;
    private Map<Coordinate, Entity> map;

    public MapRenderer(int x, int y) {
        this.X = x;
        this.Y = y;
    }

    public void render(Map<Coordinate, Entity> map) {
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                Coordinate coordinate = new Coordinate(i, j);
                Entity entity = map.get(coordinate);
                String symbol = defineSymbol(entity);
                System.out.print("[" + symbol + "]");
            }
            System.out.println();
        }
    }

    private static String defineSymbol(Entity entity) {
        return switch (entity.getClass().getName()) {
            case ("Rock") -> "Rock";
            case ("Tree") -> "Tree";
            case ("Grass") -> "Grass";
            case ("Herbivore") -> "Herbivore";
            case ("Predator") -> "Predator";
            default -> "space";
        };
    }
}

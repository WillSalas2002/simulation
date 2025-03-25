package com.will;

import com.will.entity.Entity;

public class MapRenderer {

    private final int X;
    private final int Y;

    public MapRenderer(int x, int y) {
        this.X = x;
        this.Y = y;
    }

    public void render(GameMap gameMap) {
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                Coordinate coordinate = new Coordinate(i, j);
                Entity entity = gameMap.getEntityByCoordinate(coordinate);
                String symbol = defineSymbol(entity);
                System.out.print("[" + symbol + "]");
            }
            System.out.println();
        }
    }

    private static String defineSymbol(Entity entity) {
        if (entity == null) {
            return "⬛";
        }
        return switch (entity.getClass().getSimpleName()) {
            case ("Rock") -> "\uD83D\uDC8E";
            case ("Tree") -> "\uD83C\uDF33";
            case ("Grass") -> "\uD83C\uDF40";
            case ("Herbivore") -> "\uD83D\uDC30";
            case ("Predator") -> "\uD83E\uDD81";
            default -> "⬛";
        };
    }
}

package com.will;

import com.will.entity.Entity;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class GameMap {

    @Getter
    private final int X;
    @Getter
    private final int Y;
    private Map<Coordinate, Entity> map = new HashMap<>();

    public GameMap(int x, int y) {
        X = x;
        Y = y;
    }

    public void placeEntity(Coordinate coordinate, Entity randomEntity) {
        map.put(coordinate, randomEntity);
    }

    public Entity getEntityByCoordinate(Coordinate coordinate) {
        return map.get(coordinate);
    }

    public boolean isEmpty(Coordinate coordinate) {
        return !map.containsKey(coordinate);
    }

    public int getQuantityOfEntities() {
        return map.size();
    }
}

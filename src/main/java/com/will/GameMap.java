package com.will;

import com.will.entity.Entity;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameMap {

    @Getter
    private final int X;
    @Getter
    private final int Y;
    private final Map<Coordinate, Entity> map = new HashMap<>();

    public GameMap(int x, int y) {
        X = x;
        Y = y;
    }

    public void placeEntity(Coordinate coordinate, Entity entity) {
        map.put(coordinate, entity);
    }

    public void removeEntity(Coordinate coordinate) {
        map.remove(coordinate);
    }

    public void moveEntity(Entity entity, Coordinate coordinate) {
        map.remove(entity.getCoordinate());
        entity.setCoordinate(coordinate);
        map.put(coordinate, entity);
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

    public List<Coordinate> findAllCoordinates() {
        return map.keySet().stream().toList();
    }

    public <T> List<Entity> getByType(Class<T> type) {
        return map.values().stream().filter(entity -> entity.getClass() == type).toList();
    }
}

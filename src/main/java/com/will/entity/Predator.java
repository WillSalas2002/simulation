package com.will.entity;

import com.will.Coordinate;
import com.will.GameMap;
import com.will.search.PathFinder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.LinkedList;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Predator extends Creature {

    private int strength = 20;
    private String sign = "\uD83E\uDD81";

    public Predator() {
        target = Herbivore.class.getSimpleName();
    }

    @Override
    public String getClassName() {
        return Predator.class.getSimpleName();
    }

    @Override
    public void makeMove(GameMap gameMap, PathFinder pathFinder) {
        LinkedList<Coordinate> path = pathFinder.findPath(this.coordinate);
        if (path.isEmpty()) {
            return;
        }
        Coordinate targetCoordinate = path.getFirst();
        if (path.size() == 1) {
            Herbivore herbivore = (Herbivore) gameMap.getEntityByCoordinate(targetCoordinate);
            herbivore.setHp(herbivore.getHp() - strength);
            System.out.printf("Predator from %s is eating Herbivore at %s, his target is at %s%n", this.coordinate, targetCoordinate, path.getLast());
            removeIfHpLessThanZero(gameMap, herbivore, path);
        } else {
            System.out.printf("Predator moved from: %s to %s, his target is at %s%n", this.coordinate, targetCoordinate, path.getLast());
            gameMap.moveEntity(this, targetCoordinate);
        }
    }

    private void removeIfHpLessThanZero(GameMap gameMap, Herbivore herbivore, LinkedList<Coordinate> path) {
        if (herbivore.getHp() <= 0) {
            Coordinate targetCoordinate = herbivore.getCoordinate();
            gameMap.removeEntity(targetCoordinate);
            System.out.printf("Predator from %s is ate Herbivore at %s, his target is at %s%n", this.coordinate, targetCoordinate, path.getLast());
            gameMap.moveEntity(this, targetCoordinate);
        }
    }
}

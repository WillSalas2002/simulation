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
public class Herbivore extends Creature {

    private String sign = "\uD83D\uDC30";

    public Herbivore() {
        target = Grass.class.getSimpleName();
    }

    @Override
    public String getClassName() {
        return Herbivore.class.getSimpleName();
    }

    @Override
    public void makeMove(GameMap gameMap, PathFinder pathFinder) {
        LinkedList<Coordinate> path = pathFinder.findPath(this.coordinate);
        if (path.isEmpty()) {
            System.out.printf("Herbivore from %s has nowhere to move %n", this.coordinate);
            return;
        }

        Coordinate targetCoordinate = path.getFirst();
        if (path.size() == 1) {
            Grass grass = (Grass) gameMap.getEntityByCoordinate(targetCoordinate);
            grass.setRemainingBites(grass.getRemainingBites() - 1);
            System.out.printf("Herbivore from %s is eating grass at %s%n", this.coordinate, targetCoordinate);
            removeIfLessThanZero(gameMap, grass);
        } else {
            System.out.printf("Herbivore moved from %s to %s, his target is %s%n", this.coordinate, targetCoordinate, path.getLast());
            gameMap.moveEntity(this, targetCoordinate);
        }
    }

    private void removeIfLessThanZero(GameMap gameMap, Grass grass) {
        if (grass.getRemainingBites() <= 0) {
            System.out.printf("Herbivore ate grass at %s%n", this.coordinate);
            gameMap.removeEntity(grass.getCoordinate());
            gameMap.moveEntity(this, grass.getCoordinate());
        }
    }
}

package com.will.search;

import com.will.Coordinate;
import com.will.GameMap;
import com.will.entity.Creature;
import com.will.entity.Entity;
import lombok.RequiredArgsConstructor;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

@RequiredArgsConstructor
public class BreadthFirstSearch implements PathFinder {

    private final GameMap map;

    @Override
    public LinkedList<Coordinate> findPath(Coordinate from) {
        Creature creature = (Creature) map.getEntityByCoordinate(from);

        Set<Coordinate> visited = new HashSet<>();
        Queue<Coordinate> queue = new ArrayDeque<>();
        Map<Coordinate, Coordinate> parentMap = new HashMap<>();

        queue.add(from);
        visited.add(from);
        parentMap.put(from, null);

        while (!queue.isEmpty()) {
            Coordinate currentCoordinate = queue.poll();
            Entity currentEntity = map.getEntityByCoordinate(currentCoordinate);

            if (currentEntity != null && Objects.equals(currentEntity.getClassName(), creature.getTarget())) {
                return reconstructPath(currentEntity.getCoordinate(), parentMap);
            }
            List<Coordinate> unvisitedNeighbours = findValidNeighbours(creature, currentCoordinate, parentMap, visited);
            queue.addAll(unvisitedNeighbours);
        }
        return new LinkedList<>();
    }

    private List<Coordinate> findValidNeighbours(Creature creature, Coordinate coordinate, Map<Coordinate, Coordinate> parentMap, Set<Coordinate> visited) {
        List<Coordinate> validNeighbours = new ArrayList<>();
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                Coordinate offeringCoordinate = returnValidCoordinate(coordinate, i, j);
                if (offeringCoordinate == null) continue;
                if (visited.contains(offeringCoordinate)) continue;

                Entity offeringEntity = map.getEntityByCoordinate(offeringCoordinate);
                if (offeringEntity == null || offeringEntity.getClass().getSimpleName().equals(creature.getTarget())) {
                    visited.add(offeringCoordinate);
                    validNeighbours.add(offeringCoordinate);
                    parentMap.put(offeringCoordinate, coordinate);
                }
            }
        }
        return validNeighbours;
    }

    private Coordinate returnValidCoordinate(Coordinate coordinate, int i, int j) {
        int x = coordinate.x() + i;
        int y = coordinate.y() + j;
        if ((x < 0 || y < 0 || x >= map.getX() || y >= map.getY())) {
            return null;
        }
        return new Coordinate(x, y);
    }

    private LinkedList<Coordinate> reconstructPath(Coordinate target, Map<Coordinate, Coordinate> parentMap) {
        LinkedList<Coordinate> path = new LinkedList<>();
        for (Coordinate at = target; at != null; at = parentMap.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);
        path.removeFirst();
        return path;
    }
}

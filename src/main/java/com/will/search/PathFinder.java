package com.will.search;

import com.will.Coordinate;

import java.util.LinkedList;

public interface PathFinder {

    LinkedList<Coordinate> findPath(Coordinate from);
}

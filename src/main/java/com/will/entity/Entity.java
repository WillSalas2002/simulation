package com.will.entity;

import com.will.Coordinate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Entity {

    private Coordinate coordinate;
}

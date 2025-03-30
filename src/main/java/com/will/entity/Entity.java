package com.will.entity;

import com.will.Coordinate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Entity {

    protected Coordinate coordinate;
    private String sign;

    public Entity(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public abstract String getClassName();
}

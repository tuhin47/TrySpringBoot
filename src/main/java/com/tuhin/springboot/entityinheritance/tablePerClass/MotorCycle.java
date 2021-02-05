package com.tuhin.springboot.entityinheritance.tablePerClass;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
public class MotorCycle extends Vehicle{
    private String engine;
    private double topSpeed;

    public MotorCycle(long vehicleId, String manufacturer, String engine) {
        super(vehicleId, manufacturer);
        this.engine = engine;
    }
}

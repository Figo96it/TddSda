package org.example.mock.car;

import java.util.List;

public class Car {

    private List<Tire> tires;

    public Car(List<Tire> tires) {
        this.tires = tires;
    }

    public boolean canDriveInWinter(){
        return tires.stream().filter(Tire::isWinter).count() == 4;
    }
}

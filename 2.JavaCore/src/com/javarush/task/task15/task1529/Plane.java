package com.javarush.task.task15.task1529;

public class Plane implements CanFly {
    public int countOfPassangers;

    @Override
    public void fly() {

    }

    public Plane(int countOfPassangers) {
        this.countOfPassangers = countOfPassangers;
    }
}

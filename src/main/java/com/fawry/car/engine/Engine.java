package com.fawry.car.engine;


public interface Engine {


    void onSpeedChanged(int carSpeed);

    void increase();

    void decrease();

    int getInternalSpeed();

    String getName();
}


package com.fawry.car.engine;

public class GasolineEngine implements Engine {

    private int internalSpeed = 0;

    @Override
    public void onSpeedChanged(int carSpeed) {
        System.out.println("[GasolineEngine] Speed updated to " + carSpeed + " km/h");
        this.internalSpeed = carSpeed;
    }

    @Override
    public void increase() {
        internalSpeed++;
        System.out.println("[GasolineEngine] Internal speed increased to " + internalSpeed + " km/h");
    }

    @Override
    public void decrease() {
        internalSpeed--;
        System.out.println("[GasolineEngine] Internal speed decreased to " + internalSpeed + " km/h");
    }

    @Override
    public int getInternalSpeed() {
        return internalSpeed;
    }

    @Override
    public String getName() {
        return "GasolineEngine";
    }
}


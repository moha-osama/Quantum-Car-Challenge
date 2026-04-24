package com.fawry.car;

import com.fawry.car.car.Car;
import com.fawry.car.enums.EngineType;
import com.fawry.car.factory.CarFactory;

public class Main {

    public static void main(String[] args) {

        Car car = CarFactory.createCar(EngineType.MIXED_HYBRID);

        car.start();

        car.accelerate();
        car.accelerate();
        car.accelerate();

        System.out.println("[Main] Current speed: " + car.getSpeed() + " km/h");
        System.out.println("[Main] Active engine : " + car.getEngine().getName());

        car.brake();

        System.out.println("[Main] Current speed: " + car.getSpeed() + " km/h");
        System.out.println("[Main] Active engine : " + car.getEngine().getName());

        car.brake();
        car.brake();
        car.stop();

        CarFactory.replaceEngine(car, EngineType.ELECTRIC);

        car.start();
        car.accelerate();
        car.accelerate();
        System.out.println("[Main] Current speed: " + car.getSpeed() + " km/h");
        System.out.println("[Main] Engine internal speed: " + car.getEngine().getInternalSpeed() + " km/h");
        car.brake();
        car.brake();
        car.stop();

        separator("Done!");
    }

    private static void separator(String title) {
        System.out.println("  " + title);
    }
}


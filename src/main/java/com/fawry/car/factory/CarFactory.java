package com.fawry.car.factory;

import com.fawry.car.car.Car;
import com.fawry.car.engine.ElectricEngine;
import com.fawry.car.engine.Engine;
import com.fawry.car.engine.GasolineEngine;
import com.fawry.car.engine.MixedHybridEngine;
import com.fawry.car.enums.EngineType;

public class CarFactory {

    public static Car createCar(EngineType engineType) {
        Engine engine = buildEngine(engineType);
        return new Car(engine);
    }


    public static void replaceEngine(Car car, EngineType engineType) {
        Engine newEngine = buildEngine(engineType);
        car.setEngine(newEngine);
    }

    private static Engine buildEngine(EngineType engineType) {
        return switch (engineType) {
            case GASOLINE -> new GasolineEngine();
            case ELECTRIC -> new ElectricEngine();
            case MIXED_HYBRID -> new MixedHybridEngine();
        };
    }
}


package com.fawry.car.engine;

public class MixedHybridEngine implements Engine {

    private static final int SWITCH_THRESHOLD = 50;

    private final ElectricEngine electricEngine = new ElectricEngine();
    private final GasolineEngine gasolineEngine = new GasolineEngine();

    private Engine activeEngine;

    public MixedHybridEngine() {
        activeEngine = electricEngine;
        System.out.println("[MixedHybridEngine] Initialized — active engine: ElectricEngine");
    }

    @Override
    public void onSpeedChanged(int carSpeed) {
        Engine previousEngine = activeEngine;

        if (carSpeed < SWITCH_THRESHOLD) {
            activeEngine = electricEngine;
        } else {
            activeEngine = gasolineEngine;
        }

        if (activeEngine != previousEngine) {
            System.out.println("[MixedHybridEngine] *** ENGINE SWITCH *** "
                    + previousEngine.getName() + " → " + activeEngine.getName()
                    + " at " + carSpeed + " km/h");
        }

        activeEngine.onSpeedChanged(carSpeed);
    }

    @Override
    public void increase() {
        activeEngine.increase();
    }

    @Override
    public void decrease() {
        activeEngine.decrease();
    }

    @Override
    public int getInternalSpeed() {
        return activeEngine.getInternalSpeed();
    }

    @Override
    public String getName() {
        return "MixedHybridEngine (active: " + activeEngine.getName() + ")";
    }
}


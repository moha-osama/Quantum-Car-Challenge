package com.fawry.car.car;

import com.fawry.car.engine.Engine;
import com.fawry.car.exceptions.InvalidCarStateException;

public class Car {

    private static final int MAX_SPEED = 200;
    private static final int MIN_SPEED = 0;
    private static final int SPEED_STEP = 20;

    private Engine engine;
    private int speed = 0;
    private boolean running = false;

    public Car(Engine engine) {
        this.engine = engine;
        System.out.println("[Car] Created with engine: " + engine.getName());
    }

    public void setEngine(Engine newEngine) {
        System.out.println("[Car] Replacing engine: " + engine.getName() + " → " + newEngine.getName());
        this.engine = newEngine;
        // Synchronise new engine with current speed
        this.engine.onSpeedChanged(speed);
    }

    public void start() {
        if (speed != 0) {
            throw new InvalidCarStateException(
                    "[Car] Cannot start: speed must be 0, but current speed is " + speed + " km/h");
        }
        if (running) {
            System.out.println("[Car] Car is already running.");
            return;
        }
        running = true;
        System.out.println("[Car] Car started.");
    }

    public void stop() {
        if (speed != 0) {
            throw new InvalidCarStateException(
                    "[Car] Cannot stop: speed must be 0, but current speed is " + speed + " km/h");
        }
        if (!running) {
            System.out.println("[Car] Car is already stopped.");
            return;
        }
        running = false;
        System.out.println("[Car] Car stopped.");
    }

    public void accelerate() {
        if (!running) {
            throw new InvalidCarStateException("[Car] Cannot accelerate: car is not running.");
        }
        int newSpeed = Math.min(speed + SPEED_STEP, MAX_SPEED);
        System.out.println("[Car] Accelerating: " + speed + " → " + newSpeed + " km/h");
        speed = newSpeed;
        engine.onSpeedChanged(speed);
    }

    public void brake() {
        if (!running) {
            throw new InvalidCarStateException("[Car] Cannot brake: car is not running.");
        }
        int newSpeed = Math.max(speed - SPEED_STEP, MIN_SPEED);
        System.out.println("[Car] Braking: " + speed + " → " + newSpeed + " km/h");
        speed = newSpeed;
        engine.onSpeedChanged(speed);
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isRunning() {
        return running;
    }

    public Engine getEngine() {
        return engine;
    }
}


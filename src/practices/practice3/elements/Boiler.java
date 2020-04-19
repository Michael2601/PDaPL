package practices.practice3.elements;

import org.jetbrains.annotations.NotNull;
import practices.practice3.Water;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("unused")
public class Boiler extends HeatingElement {

    private final int SECONDS_TO_HEAT;
    private String type;
    private double heatSpeed;

    public Boiler(String type, int capacity, double heatSpeed) {
        super(capacity);
        this.type = type;
        this.heatSpeed = heatSpeed;
        SECONDS_TO_HEAT = 2;
    }

    public Water start(@NotNull Water water) throws InterruptedException {
        System.out.println("Start heat");
        for (double i = water.getTemperature(); i < 80; i += heatSpeed) {
            TimeUnit.SECONDS.sleep(SECONDS_TO_HEAT);
            water.setTemperature(i);
            System.out.println("Heating! Water temperature is " + water.getTemperature());
            water.circulation();
        }
        return water;
    }

    public void stop() {
        System.out.println("Boiler stopped");
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getHeatSpeed() {
        return heatSpeed;
    }

    public void setHeatSpeed(double heatSpeed) {
        this.heatSpeed = heatSpeed;
    }

    @Override
    public String toString() {
        return "Boiler{" +
                "type='" + type + '\'' +
                ", heatSpeed=" + heatSpeed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Boiler)) return false;
        Boiler boiler = (Boiler) o;
        return Double.compare(boiler.getHeatSpeed(), getHeatSpeed()) == 0 &&
                getType().equals(boiler.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getHeatSpeed());
    }
}

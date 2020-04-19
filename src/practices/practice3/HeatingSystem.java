package practices.practice3;

import org.jetbrains.annotations.NotNull;
import practices.practice3.elements.Battery;
import practices.practice3.elements.Boiler;
import practices.practice3.elements.ExpansionTank;
import practices.practice3.elements.HeatingElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("unused")
public class HeatingSystem {
    private int capacity;
    private int fullness;
    private Boiler boiler;
    private Water water;
    private final int SECONDS_TO_COOL;
    private final double STEP_TO_COOL;

    HeatingSystem(@NotNull Boiler boiler, @NotNull List<Battery> battery, @NotNull ExpansionTank tank) {
        this.capacity = boiler.getCapacity() + battery.stream().mapToInt(HeatingElement::getCapacity).sum() + tank.getCapacity();
        this.fullness = 0;
        this.boiler = boiler;
        this.SECONDS_TO_COOL = 2;
        this.STEP_TO_COOL = 5;
    }

    public void pour(@NotNull Water water) {
        this.water = water;
        if (fullness + water.getVolume() > capacity) {
            fullness = capacity;
            System.out.println("System crowded");
        } else {
            this.fullness += water.getVolume();
            System.out.println("Water pour in");
        }
    }

    private int getPercentOfFullness() {
        return fullness / capacity * 100;
    }

    public void startHeating() {
        if (getPercentOfFullness() > 90) {
            try {
                water = boiler.start(water);
                System.out.println("Yeah we are warmed up " + water.getTemperature());
                boiler.stop();
                cooling();
                System.out.println("Ouh system is cooling " + water.getTemperature());
            } catch (Exception ignored) {
            }
        } else System.out.println("Sorry system not fully");
    }

    private void cooling() throws InterruptedException {
        for (double i = water.getTemperature(); i > 30; i -= STEP_TO_COOL) {
            TimeUnit.SECONDS.sleep(SECONDS_TO_COOL);
            water.setTemperature(i);
            System.out.println("Water is cooling! Temperature is " + water.getTemperature());
            water.circulation();
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getFullness() {
        return fullness;
    }

    public void setFullness(int fullness) {
        this.fullness = fullness;
    }

    public Boiler getBoiler() {
        return boiler;
    }

    public void setBoiler(Boiler boiler) {
        this.boiler = boiler;
    }

    public Water getWater() {
        return water;
    }

    public void setWater(Water water) {
        this.water = water;
    }
}

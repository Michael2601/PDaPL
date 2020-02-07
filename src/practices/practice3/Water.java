package practices.practice3;

@SuppressWarnings("unused")
public class Water {
    private double temperature;
    private int volume;

    public Water(int volume) {
        this.temperature = 30;
        this.volume = volume;
    }

    public Water(double temperature, int volume) {
        this.temperature = temperature;
        this.volume = volume;
    }

    public void circulation() {
        if (temperature > 60)
            System.out.println("Water circulates");
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}

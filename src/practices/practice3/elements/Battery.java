package practices.practice3.elements;

import java.util.Objects;
/**
 * @author Michael Sheshilov
 */
@SuppressWarnings("unused")
public class Battery extends HeatingElement {
    private int heatFlow;

    public Battery(int capacity) {
        super(capacity);
        this.heatFlow = 800;
    }

    public Battery(int capacity, int heatFlow) {
        super(capacity);
        this.heatFlow = heatFlow;
    }

    public int getHeatFlow() {
        return heatFlow;
    }

    public void setHeatFlow(int heatFlow) {
        this.heatFlow = heatFlow;
    }

    @Override
    public String toString() {
        return "Battery{" +
                "heatFlow=" + heatFlow +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Battery)) return false;
        Battery battery = (Battery) o;
        return getHeatFlow() == battery.getHeatFlow();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHeatFlow());
    }
}

package practices.practice8.instances;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.TreeSet;

@SuppressWarnings("unused")
public class Depot {
    private int depotNumber;
    private Collection<Train> trains = new ArrayList<>();

    public Depot(int depotNumber) {
        this.depotNumber = depotNumber;
    }

    public Depot(int depotNumber, TreeSet<Train> trains) {
        this.depotNumber = depotNumber;
        this.trains = trains;
    }

    public int getDepotNumber() {
        return depotNumber;
    }

    public void setDepotNumber(int depotNumber) {
        this.depotNumber = depotNumber;
    }

    public Collection<Train> getTrains() {
        return trains;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Depot)) return false;
        Depot depot = (Depot) o;
        return getDepotNumber() == depot.getDepotNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDepotNumber());
    }

    @Override
    public String toString() {
        return "Depot{" +
                "depotNumber=" + depotNumber +
                ", trains=" + trains +
                '}';
    }
}

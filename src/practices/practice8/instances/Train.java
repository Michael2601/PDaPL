package practices.practice8.instances;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.TreeSet;

@SuppressWarnings("unused")
public class Train {
    private String trainName;
    private Collection<CompositionElement> elements = new ArrayList<>();

    public Train(String trainName) {
        this.trainName = trainName;
    }

    public Train(String trainName, TreeSet<CompositionElement> elements) {
        this.trainName = trainName;
        this.elements = elements;
    }

    public Collection<CompositionElement> getElements() {
        return elements;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Train)) return false;
        Train train = (Train) o;
        return getTrainName().equals(train.getTrainName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTrainName());
    }

    @Override
    public String toString() {
        return "Train{" +
                "trainName='" + trainName + '\'' +
                ", elements=" + elements +
                '}';
    }
}

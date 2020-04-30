package practices.practice8.instances;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;
/**
 * @author Michael Sheshilov
 */
@SuppressWarnings("unused")
public class Railway {
    private Collection<Depot> depots = new ArrayList<>();

    public Railway() {
    }

    public Railway(TreeSet<Depot> depots) {
        this.depots = depots;
    }

    public void addTrain(int depotNumber, Train train) {
        Depot depot = getDepot(depotNumber);
        if (depot != null)
            depot.getTrains().add(train);
        else System.out.println("Depot not exists");
    }

    public void addTrain(int depotNumber, String train) {
        Depot depot = getDepot(depotNumber);
        if (depot != null)
            depot.getTrains().add(new Train(train));
        else System.out.println("Depot not exists");
    }

    public void deleteTrain(int depotNumber, String trainName) {
        Depot depot = getDepot(depotNumber);
        if (depot != null)
            depot.getTrains().removeIf(s -> s.getTrainName().equals(trainName));
        else System.out.println("Depot not exists");
    }

    public void addCompositionElement(int depotNumber, String trainName, CompositionElement element) {
        Train train = getTrain(depotNumber, trainName);
        if (train != null)
            train.getElements().add(element);
        else System.out.println("Train not exists");
    }

    public void addCompositionElement(int depotNumber, String trainName, String element) {
        Train train = getTrain(depotNumber, trainName);
        if (train != null)
            train.getElements().add(new CompositionElement(element));
        else System.out.println("Train not exists");
    }

    public void deleteCompositionElement(int depotNumber, String trainName, String compositionElementName) {
        Train train = getTrain(depotNumber, trainName);
        if (train != null)
            train.getElements().removeIf(s -> s.getCompositionElementName().equals(compositionElementName));
        else System.out.println("Train not exists");
    }

    public void addEmployee(int depotNumber, String trainName, String compositionElementName, Employee employee) {
        CompositionElement element = getCompositionElement(depotNumber, trainName, compositionElementName);
        if (element != null)
            element.getEmployees().add(employee);
        else System.out.println("Composition element not exists");
    }

    public void deleteEmployee(int depotNumber, String trainName, String compositionElementName, int id) {
        CompositionElement element = getCompositionElement(depotNumber, trainName, compositionElementName);
        if (element != null)
            element.getEmployees().removeIf(s -> s.getId() == id);
        else System.out.println("Composition element not exists");

    }

    private Depot getDepot(int depotNumber) {
        return depots.stream().filter(s -> s.getDepotNumber() == depotNumber).findAny().orElse(null);
    }

    private Train getTrain(int depotNumber, String trainName) {
        return getDepot(depotNumber).getTrains().stream().filter(s -> s.getTrainName().equals(trainName)).findAny().orElse(null);
    }

    private CompositionElement getCompositionElement(int depotNumber, String trainName, String compositionElementName) {
        return getTrain(depotNumber, trainName).getElements().stream().filter(s -> s.getCompositionElementName().equals(compositionElementName)).findAny().orElse(null);
    }

    private Employee getEmployee(int depotNumber, String trainName, String compositionElementName, int id) {
        return getCompositionElement(depotNumber, trainName, compositionElementName).getEmployees().stream().filter(s -> s.getId() == id).findAny().orElse(null);
    }

    public void addDepot(Depot depot) {
        depots.add(depot);
    }

    public void addDepot(int depotNumber) {
        depots.add(new Depot(depotNumber));
    }

    public void deleteDepot(int depotNumber) {
        depots.removeIf(s -> s.getDepotNumber() == depotNumber);
    }

    public Collection<Depot> getDepots() {
        return depots;
    }

    @Override
    public String toString() {
        return "Railway{" +
                "depots=" + depots +
                '}';
    }
}

package practices.practice7;

/**
 * @author Michael Sheshilov
 */
@SuppressWarnings("unused")
public class Month implements Comparable<Month>{
    private String name;
    private double avgT;

    Month() {
    }

    Month(String name, double avgT) {
        this.name = name;
        this.avgT = avgT;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAvgT() {
        return avgT;
    }

    public void setAvgT(double avgT) {
        this.avgT = avgT;
    }

    @Override
    public String toString() {
        return "Month{" +
                "name='" + name + '\'' +
                ", avgT=" + avgT +
                '}';
    }

    @Override
    public int compareTo(Month o) {
        return Double.compare(avgT, o.avgT);
    }
}

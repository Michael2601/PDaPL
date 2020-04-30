package labs.lab4.model;

/**
 * @author Michael Sheshilov
 */
public class Month implements Comparable<Month>{
    private int monthId;
    private String name;
    private double avgT;

    public Month() {
    }

    public Month(int monthId, String name, double avgT) {
        this.monthId = monthId;
        this.name = name;
        this.avgT = avgT;
    }

    public int getMonthId() {
        return monthId;
    }

    public void setMonthId(int monthId) {
        this.monthId = monthId;
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
                "monthId=" + monthId +
                ", name='" + name + '\'' +
                ", avgT=" + avgT +
                '}';
    }

    @Override
    public int compareTo(Month o) {
        return Double.compare(avgT, o.avgT);
    }
}

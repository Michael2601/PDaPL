package labs.lab4.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Michael Sheshilov
 */
@SuppressWarnings("unused")
public class Year {
    private List<Month> months = new ArrayList<>();

    public Year() {
    }

    public Year(List<Month> months) {
        this.months = months;
    }

    public void sortByAverageTemperature(boolean reverse) {
        months.sort(reverse ? Collections.reverseOrder() : null);
    }

    public List<Month> getMonthsRangeByAverageTemperature(double start, double end) {
        return months.stream().filter(m -> m.getAvgT() >= start && m.getAvgT() <= end).collect(Collectors.toList());
    }

    public void addMonth(Month month) {
        this.months.add(month);
    }

    public void addMonth(int monthId, String name, double avgT) {
        this.months.add(new Month(monthId, name, avgT));
    }

    public Collection<Month> getMonths() {
        return months;
    }

    public void setMonths(List<Month> months) {
        this.months = months;
    }
}

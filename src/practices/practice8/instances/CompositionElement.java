package practices.practice8.instances;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.TreeSet;

@SuppressWarnings("unused")
public class CompositionElement {
    private String compositionElementName;
    private Collection<Employee> employees = new ArrayList<>();

    public CompositionElement(String compositionElementName) {
        this.compositionElementName = compositionElementName;
    }

    public CompositionElement(String compositionElementName, TreeSet<Employee> employees) {
        this.compositionElementName = compositionElementName;
        this.employees = employees;
    }

    public String getCompositionElementName() {
        return compositionElementName;
    }

    public void setCompositionElementName(String compositionElementName) {
        this.compositionElementName = compositionElementName;
    }

    public Collection<Employee> getEmployees() {
        return employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompositionElement)) return false;
        CompositionElement element = (CompositionElement) o;
        return getCompositionElementName().equals(element.getCompositionElementName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCompositionElementName());
    }

    @Override
    public String toString() {
        return "CompositionElement{" +
                "compositionElementName='" + compositionElementName + '\'' +
                ", employees=" + employees +
                '}';
    }
}

package practices.practice3.elements;

import java.util.Objects;

@SuppressWarnings("unused")
public class ExpansionTank extends HeatingElement {
    private String material;

    public ExpansionTank(int capacity, String material) {
        super(capacity);
        this.material = material;
    }


    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "ExpansionTank{" +
                "material='" + material + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExpansionTank)) return false;
        ExpansionTank that = (ExpansionTank) o;
        return getMaterial().equals(that.getMaterial());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMaterial());
    }
}

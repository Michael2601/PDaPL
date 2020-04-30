package practices.practice3.elements;
/**
 * @author Michael Sheshilov
 */
@SuppressWarnings("unused")
public abstract class HeatingElement {
    private int capacity;

    HeatingElement(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public abstract int hashCode();

    @Override
    public abstract boolean equals(Object obj);

    @Override
    public abstract String toString();
}

package hello.core.CallOfValueAndReference;

public class ValueAndRef {
    private int value;

    public ValueAndRef(int i) {
        this.value = i;
    }

    public void setValue(int i) {
        this.value = i;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}

package interpreter.bytecode;

/**
 * Used for if a bytecode has a reference to somewhere else in the code via a label
 */
public abstract class RefByteCode extends ByteCode {
    private int location;
    private String label;

    public String getLabel() {
        return label;
    }
    public String setLabel(String label) {
        this.label = label;
        return this.label;
    }

    public int getLocation() {
        return location;
    }

    public int setLocation(int i) {
        location = i;
        return location;
    }
}

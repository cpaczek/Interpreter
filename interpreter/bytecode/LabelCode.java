package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 * The Label ByteCode is a ByteCode that has no functionality. Its sole purpose is to mark
 * locations in the program where other ByteCodes can jump to. Label ByteCodes will be used
 * to address resolution so other ByteCodes know where they are supposed to jump to.
 */
public class LabelCode extends ByteCode {
    public String labelData;
    @Override
    public void init(ArrayList<String> args) {
        labelData = args.get(0);
    }
    public String toString() {
        return "LABEL " + labelData;
    }
    @Override
    public void execute(VirtualMachine vm) {
        return;

    }
}

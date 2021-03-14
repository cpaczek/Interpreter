package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class LabelCode extends ByteCode {
    public String labelData;
    @Override
    public void init(ArrayList<String> args) {
        labelData = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        return;

    }
}

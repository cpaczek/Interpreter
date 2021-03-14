package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class DumpCode extends ByteCode {
    String val;

    @Override
    public void init(ArrayList<String> args) {
        val = args.get(1);
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.setDump(val.equals("ON"));
    }
}

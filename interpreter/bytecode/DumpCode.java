package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 * The Dump ByteCode is used to turn dumping ON and OFF. Dumping in the interpreter
 * project is only done when dumping is ON.
 */
public class DumpCode extends ByteCode {
    String val;

    @Override
    public void init(ArrayList<String> args) {
        val = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.setDump(val.equals("ON"));
    }
}

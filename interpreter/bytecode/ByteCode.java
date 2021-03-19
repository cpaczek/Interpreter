package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 * Byte Code required functions
 */
public abstract class ByteCode {
    public abstract void init(ArrayList<String> args);
    public abstract void execute(VirtualMachine vm);
}

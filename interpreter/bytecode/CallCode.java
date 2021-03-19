package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;
import java.util.List;

/**
 * The Call ByteCode is what the VirtualMachine uses to jump to locations in the program to
 * execute sections of code we call Functions. When encountered the Call ByteCode will jump
 * to the corresponding label in the program. The ByteCde is also responsible of keeping track
 * of where control should return to when a function completes its execution.
 */
public class CallCode extends RefByteCode {
    String arguments;
    @Override
    public void init(ArrayList<String> args) {
        super.setLabel(args.get(0));
    }
    @Override
    public String toString() {
        return "CALL " + (super.getLabel() == null ? "" : super.getLabel() + " " + super.getLabel().split("<")[0] + "(" + arguments + ")");
    }
    @Override
    public void execute(VirtualMachine vm) {
        arguments = vm.formatArgs();
        vm.pushToReturnStack();
        vm.setProgramCounter(super.getLocation());
    }
}

package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 * The Goto ByteCode is used to jump to Labels in our programs. Goto is considered an
 * unconditional jump. This means regardless of the state of the program, we take the jump.
 * Goto has one argument, the label it needs to jump to. Like FalseBranch, Goto’s label needs
 * to go through address resolution as well.
 */
public class GotoCode extends RefByteCode {

    @Override
    public void init(ArrayList<String> args) {
        super.setLabel(args.get(0));
    }
    public String toString() {
        return "GOTO " + super.getLabel();
    }
    @Override
    public void execute(VirtualMachine vm) {
        vm.setProgramCounter(super.getLocation());
    }
}

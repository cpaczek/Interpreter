package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 * The HALT ByteCode is used to alert the virtual machine that program execution is to be
 * stopped. Halt is not allowed to kill the interpreter program. Therefore, Halt may not call
 * System.out.exit to stop the execution of the program.
 */
public class HaltCode extends ByteCode {
    @Override
    public void init(ArrayList<String> args) {

    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.halt();
    }
}

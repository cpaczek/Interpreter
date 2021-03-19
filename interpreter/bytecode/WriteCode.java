package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 * The Write ByteCode is used to display information to the console. The only thing Write is
 * allowed to display is the top value of the runtime stack. No other information is allowed to
 * be shown.
 */
public class WriteCode extends ByteCode{
    @Override
    public void init(ArrayList<String> args) {

    }
    public String toString() {
        return "WRITE";
    }
    @Override
    public void execute(VirtualMachine vm) {
        System.out.println(vm.peekRuntimeStack());

    }
}

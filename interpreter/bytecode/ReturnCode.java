package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 * The Return ByteCode will be used to return from functions but also to put return values in
 * the correct position on the runtime stack. The interpreter project will use this convention for
 * handling arguments and return values. Callers of functions are required to setup argument
 * for the functions they call. Functions themselves (callees) are required to put return values
 * in the correct spot just before returning from a function. Note that this is a convention we
 * will adhere to and is something that is not enforced programmatically. This means if you
 * fail to follow this convention, transient bugs can happen. The Return ByteCode has a lot of
 * responsibility. The steps for completing a return is important.
 */
public class ReturnCode extends ByteCode {
    String identifier;
    int returnLocation;
    @Override
    public void init(ArrayList<String> args) {
        if(!args.isEmpty()){
            identifier = args.get(0);
        }

    }
    @Override
    public String toString() {
        return "RETURN " + (identifier == null ? "" : (identifier + " " + "EXIT " + identifier.split("<")[0]+ " : " + returnLocation));
    }
    @Override
    public void execute(VirtualMachine vm) {
        int returnValue = vm.popRuntimeStack();
        vm.popFrame();
        vm.pushToRuntimeStack(returnValue);
        returnLocation = vm.popReturnStack();
        vm.setProgramCounter(returnLocation);

    }
}

package interpreter.bytecode;


import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;


/**
 * The Lit ByteCode is used to push literal values to the runtime stack. In some cases, Lit
 * ByteCodes will be accompanied with an id ( a variable name ), this id represents the variable
 * name the value belongs to. This id is optional.
 */
public class LitCode extends ByteCode {
    int value;
    String identifier;
    @Override
    public void init(ArrayList<String> args) {
        value = Integer.parseInt(args.get(0));
        if(args.size() > 1){
            identifier = args.get(1);
        }


    }

    @Override
    public String toString() {
        return "LIT " + value + " " + (identifier == null ? "" : (identifier + " " + "int" + identifier));
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.pushToRuntimeStack(value);

    }
}

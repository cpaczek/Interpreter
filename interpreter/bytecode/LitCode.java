package interpreter.bytecode;


import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;


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
    public void execute(VirtualMachine vm) {
        vm.pushToRuntimeStack(value);

    }
}

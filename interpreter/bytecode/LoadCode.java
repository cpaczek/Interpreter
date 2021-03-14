package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class LoadCode extends ByteCode {
    int offset;
    String identifier;
    @Override
    public void init(ArrayList<String> args) {
        offset = Integer.parseInt(args.get(0));
        if(args.size() > 1){
            identifier = args.get(1);
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.loadRuntimeStack(offset);
    }
}

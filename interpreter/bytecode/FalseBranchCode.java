package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class FalseBranchCode extends RefByteCode {

    @Override
    public void init(ArrayList<String> args) {
        super.setLabel(args.get(0));
    }

    @Override
    public void execute(VirtualMachine vm) {
        if(vm.popRuntimeStack() == 0){
            vm.setProgramCounter(super.getLocation());
        }

    }
}

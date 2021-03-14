package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class CallCode extends RefByteCode {
    @Override
    public void init(ArrayList<String> args) {
        super.setLabel(args.get(0));
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.pushToReturnStack();
        int test = super.getLocation();
        vm.setProgramCounter(super.getLocation());
    }
}
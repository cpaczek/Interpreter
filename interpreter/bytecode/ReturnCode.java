package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class ReturnCode extends ByteCode {
    @Override
    public void init(ArrayList<String> args) {

    }

    @Override
    public void execute(VirtualMachine vm) {
        int returnValue = vm.popRuntimeStack();
        vm.popFrame();
        vm.pushToRuntimeStack(returnValue);
        vm.setProgramCounter(vm.popReturnStack());

    }
}

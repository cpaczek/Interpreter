package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class PopCode extends ByteCode {
    private int n;

    @Override
    public void init(ArrayList<String> args) {
        n = Integer.parseInt(args.get(0));
    }

    @Override
    public void execute(VirtualMachine vm) {
        int j = Math.min(n, vm.currentFrameSize());
        for(int i = 0; i < j; i++){
            vm.popRuntimeStack();
        }
    }
}

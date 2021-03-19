package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 * The Pop ByteCode will be used to remove values from the run time stack. The Pop ByteCode
 * is not allowed to remove values across frame boundaries. It is the implementers responsibility
 * to ensure that Pop is only allowed to pop the appropriate number of values. Pop has one
 * argument, N , which is the number of values to be popped. You cannot make any assumptions
 * about the value of N other than it is a strictly positive number.
 */
public class PopCode extends ByteCode {
    private int n;

    @Override
    public void init(ArrayList<String> args) {
        n = Integer.parseInt(args.get(0));
    }
    public String toString() {
        return "POP " + n;
    }
    @Override
    public void execute(VirtualMachine vm) {
        int j = Math.min(n, vm.currentFrameSize());
        for(int i = 0; i < j; i++){
            vm.popRuntimeStack();
        }
    }
}

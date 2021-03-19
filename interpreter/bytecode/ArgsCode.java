package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 *The Args ByteCode is going to be used to setup how many arguments a function has. The
 * Args ByteCode will always be executed just before a Call ByteCode. The Args ByteCode
 * has one argument, the number of values that are arguments for the next function call. This
 * value N, will be used to determine how many values starting from the top of the runtime
 * stack will be a part of a newly created activation frame for the next function call. Args will
 * need to figure out where in the runtime stack this new frame begins at and push this index
 * into the FramePointer stack.
 */
public class ArgsCode extends ByteCode {
    int n;
    @Override
    public void init(ArrayList<String> args) {
        n = Integer.parseInt(args.get(0));
    }

    @Override
    public String toString() {
        return "ARGS " + n;
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.newFrameAt(n);
    }
}

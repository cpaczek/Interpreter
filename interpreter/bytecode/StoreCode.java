package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 * The Store ByteCode will be used to move values from the top of the run time stack to an
 * offset in the current frame. This offset starts from the beginning of the frame. The idea
 * behind this ByteCode is it is needed to do operations like assignments. The Store ByteCode
 * is not allowed to operate across frame boundaries.
 */
public class StoreCode extends ByteCode {
    int offset;
    String identifier;
    private int value;
    @Override
    public void init(ArrayList<String> args) {
        offset = Integer.parseInt(args.get(0));
        if(args.size() > 1){
            identifier = args.get(1);
        }

    }
    @Override
    public String toString() {
        return "STORE " + offset + " " + (identifier == null ? "" : (identifier + " " + identifier + "=" + value));
    }
    @Override
    public void execute(VirtualMachine vm) {
        value = vm.popRuntimeStack();
        vm.setRuntimeStack(value, offset);

    }
}

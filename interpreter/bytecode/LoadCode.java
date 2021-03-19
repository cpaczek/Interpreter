package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 * The Load ByteCode will be used to move values from an offset in the current frame to the
 * top of the stack. This offset works from the beginning of the frame. The purpose behind this
 * ByteCode is it is needed to setup copies of values for things like expressions and arguments
 * for functions. The load ByteCode is not allowed to operate across frame boundaries.
 */
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
    public String toString() {
        return "LOAD " + offset + " " + (identifier == null ? "" : (identifier + " " + "<load " + identifier + ">"));
    }
    @Override
    public void execute(VirtualMachine vm) {
        vm.loadRuntimeStack(offset);
    }
}

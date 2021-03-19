package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 * The FalseBranch ByteCode will be used to execute conditional jumps( think of executing
 * control structures like if-statements and loops). FalseBranch will have one argument. This
 * argument is a Label that will mark a place in the program to jump to. FalseBranch will
 * remove the top value of the run time stack and check to see if the value is 0. If the value is 0,
 * jump the corresponding label. If the value is something else, move to the next ByteCode in
 * the program. FalseBranch will need to have its label address calculated before the program
 * begins executing. This requires finding where the destination of the jump is going to be
 * numerically(address in the program) in the program.
 */
public class FalseBranchCode extends RefByteCode {

    @Override
    public void init(ArrayList<String> args) {
        super.setLabel(args.get(0));
    }
    @Override
    public String toString() {
        return "FALSEBRANCH " + super.getLabel();
    }
    @Override
    public void execute(VirtualMachine vm) {
        if(vm.popRuntimeStack() == 0){
            vm.setProgramCounter(super.getLocation());
        }

    }
}

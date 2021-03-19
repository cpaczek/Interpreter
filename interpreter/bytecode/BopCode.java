package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 * The Bop ByteCode is used to implement binary operations for the Interpreter Project. The
 * Bop ByteCode will need to remove 2 values from the runtime stack and operate on them
 * according to an operation. The result needs to be pushed back to the top of the stack. Be
 * careful, the order of the operands matter. HINT: operands will be pushed in the correct
 * order but the popped in the reverser order.
 */
public class BopCode extends ByteCode {
    String operator;

    @Override
    public void init(ArrayList<String> args) {
        operator = args.get(0);

    }
    @Override
    public String toString() {
        return "ARGS " + operator;
    }
    @Override
    public void execute(VirtualMachine vm) {
        int SecondOperand = vm.popRuntimeStack();
        int firstOperand = vm.popRuntimeStack();
        switch (operator) {
            case "+" -> vm.pushToRuntimeStack(firstOperand + SecondOperand);
            case "-" -> vm.pushToRuntimeStack(firstOperand - SecondOperand);
            case "/" -> vm.pushToRuntimeStack(firstOperand / SecondOperand);
            case "*" -> vm.pushToRuntimeStack(firstOperand * SecondOperand);
            case "==" -> vm.pushToRuntimeStack(firstOperand == SecondOperand ? 1 : 0);
            case "!=" -> vm.pushToRuntimeStack(firstOperand != SecondOperand ? 1 : 0);
            case "<=" -> vm.pushToRuntimeStack(firstOperand <= SecondOperand ? 1 : 0);
            case ">" -> vm.pushToRuntimeStack(firstOperand > SecondOperand ? 1 : 0);
            case ">=" -> vm.pushToRuntimeStack(firstOperand >= SecondOperand ? 1 : 0);
            case "<" -> vm.pushToRuntimeStack(firstOperand < SecondOperand ? 1 : 0);
            case "|" -> vm.pushToRuntimeStack((firstOperand == 1 || SecondOperand == 1) ? 1 : 0);
            case "&" -> vm.pushToRuntimeStack((firstOperand == 1 && SecondOperand == 1) ? 1 : 0);
        }


    }
}

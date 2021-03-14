package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class BopCode extends ByteCode {
    String operator;

    @Override
    public void init(ArrayList<String> args) {
        operator = args.get(0);

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

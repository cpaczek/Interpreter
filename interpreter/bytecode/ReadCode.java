package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;
import java.util.Scanner;

public class ReadCode extends ByteCode {
    @Override
    public void init(ArrayList<String> args) {

    }

    @Override
    public void execute(VirtualMachine vm) {
        String input;
        do{
            System.out.print("Please enter an integer : ");
            Scanner sc = new Scanner(System.in);
            input = sc.nextLine();
        }while( !input.matches("-?\\d+"));
        vm.pushToRuntimeStack(Integer.parseInt(input));

    }
}

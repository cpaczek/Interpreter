package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Read ByteCode is used to read user input from the keyboard. Only integers should be
 * accepted from users. You may use Scanners or BufferedReaders to read input from the user.
 */
public class ReadCode extends ByteCode {
    @Override
    public void init(ArrayList<String> args) {

    }
    public String toString() {
        return "READ";
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

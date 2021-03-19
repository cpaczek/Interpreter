
package interpreter;

import interpreter.bytecode.ByteCode;
import interpreter.virtualmachine.Program;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;


public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;


    /**
     * @param file The .cod file of the compiled program that uses valid bytecodes.
     * @throws IOException
     */
    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }

    /**
     * This takes the program file (.cod) and goes line by line to find the byte codes
     * Once it finds a valid byte code it will convert the string to a bytecode object
     * Then it will init the bytecode and pass in the args that are separated by 1+ spaces
     */
    public Program loadCodes() {
        //Value of the current line
        String line;
        //Value of the Bytecode Class Name
        String className;
        //The Raw byte code name
        String byteCodeName;
        //All of the items split by spaces
        String[] items;
        Class classBluePrint;
        Program program = new Program();
        ByteCode bc;
        try {
            //This while loop codes line by line and parses the program file
            while (this.byteSource.ready()) {
                line = this.byteSource.readLine();
                items = line.split("\\s+");//Splits the line by 1 or more Spaces
                byteCodeName = items[0]; //The bytecode name will be the first item.
                className = CodeTable.getClassName(byteCodeName); //gets the Class name from the bytecode
                classBluePrint = Class.forName("interpreter.bytecode." + className); //Makes the class object via a blueprint
                bc = (ByteCode) classBluePrint.getDeclaredConstructor().newInstance(); //Casts the blueprint to a bytecode object
                ArrayList<String> ByteCodeArgs = new ArrayList<>(Arrays.asList(items).subList(1, items.length)); //An arraylist of the arguments to pass into the bytecode init
                bc.init(ByteCodeArgs); // init the bytecode
                program.addByteCode(bc); //Add the new bytecode to the program arraylist


            }
        } catch (IOException | ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
            System.exit(255);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        program.resolveAddress();
        return program;

    }
}

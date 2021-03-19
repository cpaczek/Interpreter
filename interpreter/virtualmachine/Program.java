package interpreter.virtualmachine;

import interpreter.bytecode.ByteCode;
import interpreter.bytecode.FalseBranchCode;
import interpreter.bytecode.LabelCode;
import interpreter.bytecode.RefByteCode;

import java.sql.Ref;
import java.util.ArrayList;
import java.util.HashMap;

public class Program{

    private ArrayList<ByteCode> program;

    public Program() {
        program = new ArrayList<>();
    }

    /**
     * @param programCounter What index to get from the program list
     * @return Returns the bytecode object that needs to be executed.
     */
    public ByteCode getCode(int programCounter) {
        return this.program.get(programCounter);
    }

    /**
     * @param code The bytecode to be added to the program arraylist
     */
    public void addByteCode(ByteCode code) {
        program.add(code);
    }


    /**
     * This will resolve the address of btyecodes that jump to different places
     */
    public void resolveAddress() {
        HashMap<String, LabelCode> labelTable = new HashMap<>();
        //Finds Label Codes
        program.forEach(code -> {
            if (code instanceof LabelCode) {
                //After it found a code it will put the label bytecode object aswell as the label string into a hashmap
                labelTable.put(((LabelCode) code).labelData, (LabelCode) code);
            }
        });
        program.forEach(code -> {
            //Check if a bytecode has a reference to another location in the code
            if (code instanceof RefByteCode) {
                //It will set the location of where to jump by searching for the index of the label code from the program array list and to find the correct label
                //object we use the hashmap that we filled with our first forloop
                ((RefByteCode) code).setLocation(program.indexOf(labelTable.get(((RefByteCode) code).getLabel())));
            }
        });

    }


}

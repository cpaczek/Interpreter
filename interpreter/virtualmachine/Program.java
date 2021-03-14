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

    public ByteCode getCode(int programCounter) {
        return this.program.get(programCounter);
    }

    public void addByteCode(ByteCode code) {
        program.add(code);
    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter
     * HINT: make note what type of data-structure ByteCodes are stored in.
     */
    public void resolveAddress() {
        HashMap<String, LabelCode> labelTable = new HashMap<>();
        //Finds Label Codes
        program.forEach(code -> {
            if (code instanceof LabelCode) {
                labelTable.put(((LabelCode) code).labelData, (LabelCode) code);
            }
        });
        program.forEach(code -> {
            if (code instanceof RefByteCode) {
                ((RefByteCode) code).setLocation(program.indexOf(labelTable.get(((RefByteCode) code).getLabel())));
            }
        });

    }
    public int getPositionOfByteCode(ByteCode code){
        return program.indexOf(code);
    }


}

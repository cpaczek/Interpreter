package interpreter.virtualmachine;

import interpreter.bytecode.ByteCode;

import java.lang.reflect.Method;
import java.util.List;

public class VirtualMachine {

    private RunTimeStack runTimeStack;
    private Program program;
    private int programCounter;
    private boolean isRunning;
    private boolean dump;
    // VM Constructor
    public VirtualMachine(Program program) {
        this.program = program;
    }
    // Main Program Loop
    public void executeProgram() {
        dump = false;
        //Start the program at the first index
        programCounter = 0;
        //Make a new runtime stack
        runTimeStack = new RunTimeStack();
        //Set the program to start
        isRunning = true;
        //Main program loop
        while (isRunning) {

            //Gets the current ByteCode in the Program Array
            ByteCode code = program.getCode(programCounter);
            //Executes the bytecode and passes in the Current VM
            code.execute(this);
            if(dump){
                if(overridesToString(code.getClass())){
                    System.out.println(code);
                }
                System.out.print(dumpRuntimeStack());
                System.out.println("");
            }
            //Go to the next line
            programCounter++;
        }
    }
    /*
     * VM Functions
     * */

    /**
     * @return Returns the args of a new function seperated  by commas
     */
    public String formatArgs(){
        StringBuilder formattedArgs = new StringBuilder();
        List<Integer> arguments = dumpRuntimeStack();
        if(!arguments.isEmpty()){
            for(int i = 0; i < arguments.size(); i++){
                formattedArgs.append(arguments.get(i));
                if (i != arguments.size() -1){
                    formattedArgs.append(",");
                }
            }
        }
        return formattedArgs.toString();
    }

    /**
     * @param clazz The class that you want to check overrides tostring
     * @return A boolean value if the class that you picked overrides tostring.
     */
    public static boolean overridesToString(Class<?> clazz) {
        Method m;
        try {
            m = clazz.getMethod("toString");
        } catch (NoSuchMethodException e) {
            // Can't be thrown since every class has a toString method through Object
            return false;
        }
        return (m.getDeclaringClass() != Object.class);
    }
    /**
     * Used for Calls Gotos and False branches allows the program to jump to other parts of code
     *
     * @param val Sets the current position that the VM will execute
     */
    public void setProgramCounter(int val) {
        programCounter = val;
    }

    /**
     * @param dump Boolean value whether dumping is on or off.
     */
    public void setDump(boolean dump) {
        this.dump = dump;
    }

    /**
     * Gracefully stops the program (allows for the current runtime loop to complete)
     */
    public void halt() {
        isRunning = false;
    }


    /*
     * Runtime Stack Functions
     * */

    /**
     * @see RunTimeStack#peek()
     */
    public int peekRuntimeStack() {
        return runTimeStack.peek();
    }

    /**
     * @see RunTimeStack#push(int)
     */
    public int pushToRuntimeStack(int val) {
        return runTimeStack.push(val);
    }

    /**
     * @see RunTimeStack#pop()
     */
    public int popRuntimeStack() {
        return runTimeStack.pop();
    }

    /**
     * @see RunTimeStack#load(int)
     */
    public void loadRuntimeStack(int offset) {
        runTimeStack.load(offset);
    }
    /**
     * @see RunTimeStack#setRuntimeStackValue(int, int)
     */
    public void setRuntimeStack(int value, int offset) {
        runTimeStack.setRuntimeStackValue(value, offset);
    }

    /**
     * Dumps the runtime stack to console
     */
    private List<Integer> dumpRuntimeStack() {
        return runTimeStack.dump();
    }
    /*
     * Frame Pointer Function
     * */
    /**
     * @see RunTimeStack#newFrameAt(int)
     */
    public void newFrameAt(int offset) {
        runTimeStack.newFrameAt(offset);
    }
    /**
     * @see RunTimeStack#popFrame()
     */
    public void popFrame() {
        runTimeStack.popFrame();
    }
    /**
     * @see RunTimeStack#currentFrameSize()
     */
    public int currentFrameSize() {
        return runTimeStack.currentFrameSize();
    }

    /*
     * Return Stack Functions
     * */
    /**
     * @see RunTimeStack#popReturnAddressStack()
     */
    public int popReturnStack() {
        return runTimeStack.popReturnAddressStack();
    }
    /**
     * @see RunTimeStack#pushReturnAddressStack(int)
     */
    public void pushToReturnStack() {
        runTimeStack.pushReturnAddressStack(programCounter);
    }
}

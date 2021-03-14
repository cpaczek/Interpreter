package interpreter.virtualmachine;

import interpreter.bytecode.ByteCode;

import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack   runTimeStack;
    private Stack<Integer> returnAddress;
    private Program        program;
    private int            programCounter;
    private boolean        isRunning;
    private boolean        dump;

    public VirtualMachine(Program program) {
        this.program = program;
    }

    public void executeProgram() {
        programCounter = 0;
        runTimeStack = new RunTimeStack();
        returnAddress = new Stack<Integer>();
        isRunning = true;
        while(isRunning){
            ByteCode code = program.getCode(programCounter);
            code.execute(this);
            programCounter++;
        }
    }
    public void pushToReturnStack(){
        runTimeStack.pushReturnAddressStack(programCounter);
    }
    public int peekRuntimeStack(){
        return runTimeStack.peek();
    }
    public void setDump(boolean dump){
        this.dump = dump;
    }
    public int popReturnStack(){
        return runTimeStack.popReturnAddressStack();
    }
    public void halt(){
        isRunning = false;
    }
    public int popRuntimeStack(){
        return runTimeStack.pop();
    }
    public int currentFrameSize(){
        return runTimeStack.currentFrameSize();
    }
    public int getRuntimeStackSize(){
        return runTimeStack.getRuntimeStackSize();
    }
    public int peekFramePointer(){
        return runTimeStack.peekFramePointer();
    }
    public void newFrameAt(int offset){
        runTimeStack.newFrameAt(offset);
    }
    public void popFrame(){
        runTimeStack.popFrame();
    }
    public void setRuntimeStack(int value,  int offset){
        runTimeStack.setRuntimeStackValue(value, offset);
    }
    public void loadRuntimeStack(int offset){
        runTimeStack.load(offset);
    }
    public int pushToRuntimeStack(int val){
        return runTimeStack.push(val);
    }
    public void setProgramCounter(int val){
        programCounter = val;
    }

}

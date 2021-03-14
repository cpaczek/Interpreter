package interpreter.virtualmachine;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

class RunTimeStack {

    private ArrayList<Integer> runTimeStack;
    private Stack<Integer> framePointer;
    private Stack<Integer> returnAddressStack;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        returnAddressStack = new Stack<>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    public static void main(String[] args) {
        RunTimeStack rs = new RunTimeStack();
        rs.push(1);
        rs.push(2);
        rs.push(3);
        rs.newFrameAt(0);
        rs.push(4);
        rs.push(5);
        rs.push(6);
        rs.newFrameAt(0);
        rs.push(7);
        rs.push(8);
        System.out.println();
        System.out.println();
        System.out.println();
        rs.runTimeStack.forEach(System.out::println);
        rs.dump();

    }

    public void dump() {
        System.out.println(framePointer);
        int rtsTop = runTimeStack.size() - 1;
        ArrayList<Integer> currentFrameValues = new ArrayList<>();
        Stack<Integer> tempFramePointer = (Stack<Integer>) framePointer.clone();
        for(int i = rtsTop; !tempFramePointer.empty() && i >= 0; i-- ){

            currentFrameValues.add(runTimeStack.get(i));
            if(i == tempFramePointer.peek()){
                tempFramePointer.pop();
                System.out.println(currentFrameValues);
                currentFrameValues = new ArrayList<>();
            }

        }

    }

    public int peek() {
        return this.runTimeStack.get(this.runTimeStack.size()-1);
    }

    public int push(int i) {
        this.runTimeStack.add(i);
        return this.peek();
    }

    public int pop() {
        return this.runTimeStack.remove(this.runTimeStack.size()-1);

    }

    public int store(int offset) {
        int runtimePointer = this.framePointer.peek() + offset;
        return runTimeStack.set(runtimePointer, pop());
    }
    public void pushReturnAddressStack(int val){
        returnAddressStack.push(val);
    }
    public int popReturnAddressStack(){
        return returnAddressStack.pop();
    }
    public int load(int offset) {
        int runtimePointer = this.framePointer.peek() + offset;
        return push(runTimeStack.get(runtimePointer));
    }
    public int currentFrameSize(){
        return runTimeStack.size() - framePointer.peek();
    }
    public void setRuntimeStackValue(int value, int offset){
        runTimeStack.set(framePointer.peek() + offset, value);
    }

    public void newFrameAt(int offset) {
        this.framePointer.add(this.runTimeStack.size() - offset);
    }
    public int getRuntimeStackSize(){
        return runTimeStack.size();
    }
    public int peekFramePointer(){
        return framePointer.peek();
    }

    public void popFrame() {
        int lowerVal = this.framePointer.pop();
        for(int i = this.runTimeStack.size(); i > lowerVal; i--){
            this.pop();
        }
    }


}

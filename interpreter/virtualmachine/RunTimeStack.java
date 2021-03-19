package interpreter.virtualmachine;

import java.util.ArrayList;
import java.util.List;
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

    /**
     *
     * This main function is used for testing the functions within this class and does not have any effect on the
     * execution of a program
     *
     * @param args Any java command line argument
     */
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

    /*
     * Frame Pointer Functions
     * */


    /**
     * This function will look at the runtime stack and determine how many values are in the current frame.
     *
     * @return Returns the current frame size
     */
    public int currentFrameSize() {
        return runTimeStack.size() - framePointer.peek();
    }

    /**
     * @param offset Provide an offset from the top of the runtime stack on where to add the pointer
     */
    public void newFrameAt(int offset) {
        this.framePointer.add(this.runTimeStack.size() - offset);
    }

    /**
     * Removes all the values in the current frame in the runtime stack aswell as the frame pointer in the frame pointer stack.
     */
    public void popFrame() {
        int lowerVal = this.framePointer.pop();
        for (int i = this.runTimeStack.size(); i > lowerVal; i--) {
            this.pop();
        }
    }

    /*
     * Runtime Stack Function
     * */


    /**
     * Dumps the runtime stack into seperate arrays based on frame pointers
     * @return returns the current frame values
     */
    public List<Integer> dump() {
        int firstSubIndex = 0;
        for (int i = 1; i < this.framePointer.size(); i++) {
            int nextSubIndex = this.framePointer.get(i);
            System.out.print(this.runTimeStack.subList(firstSubIndex, nextSubIndex) + " ");
            firstSubIndex = nextSubIndex;
        }
        return this.runTimeStack.subList(firstSubIndex, this.runTimeStack.size());

    }

    /**
     * @return Provides the top value on the runtime stack.
     */
    public int peek() {
        return this.runTimeStack.get(this.runTimeStack.size() - 1);
    }

    /**
     * @param i Value to add to the runtime stack
     * @return returns the pushed value by peeking the stack
     */
    public int push(int i) {
        this.runTimeStack.add(i);
        return this.peek();
    }

    /**
     * @param offset Offset from the top of the stack
     * @return returns the value stored.
     */
    public int store(int offset) {
        int runtimePointer = this.framePointer.peek() + offset;
        return runTimeStack.set(runtimePointer, pop());
    }

    /**
     * @return Returns the item just removed from the top of the runtime stack
     */
    public int pop() {
        return this.runTimeStack.remove(this.runTimeStack.size() - 1);

    }

    /**
     * @param offset Offset from the current frame
     * @return returns the item moved that is now on top of the runtime stack
     */
    public int load(int offset) {
        int runtimePointer = this.framePointer.peek() + offset;
        return push(runTimeStack.get(runtimePointer));
    }

    /**
     * This will overwrite an existing value and will not add a new one.
     *
     * @param value The value that you are inserting into the stack
     * @param offset Offset from the current frame pointer
     */
    public void setRuntimeStackValue(int value, int offset) {
        runTimeStack.set(framePointer.peek() + offset, value);
    }


    /*
     * Return Stack Functions
     * */


    /**
     * @param val Value to push to the return address stack
     */
    public void pushReturnAddressStack(int val) {
        returnAddressStack.push(val);
    }

    /**
     * @return Returns the popped value from the address stack
     */
    public int popReturnAddressStack() {
        return returnAddressStack.pop();
    }


}

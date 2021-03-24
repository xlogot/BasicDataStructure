package stack.SequentialStack;

import stack.IStack;

public class SequentialStack implements IStack {
    private int[] data;
    private int top=-1;
    private int maxSize;
    public SequentialStack(int size)
    {
        data = new int[size];
        maxSize = size - 1;
    }
    public int getTop(){
        return top;
    }
    public boolean IsEmpty()
    {
        return top == -1;
    }

    public boolean IsFull()
    {
        return top == maxSize-1;
    }

    public int pop() throws Exception {
        if (top==-1)
        {
            throw new Exception("stack is empty");
        }
        int result = data[top];
        top--;
        return result;
    }

    public void push(int item)
    {
        if (top==maxSize-1)
        {
            return;
        }
        top++;
        data[top] = item;
    }
}

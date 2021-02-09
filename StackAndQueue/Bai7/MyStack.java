public class MyStack
{
    private int[] arr;
    private int top;
    private int maxCapacity;
    
    public MyStack(int maxSize)
    {
        maxCapacity = maxSize;
        arr = new int[maxCapacity];
        top = -1;
    }

    public void push(int val)
    {
        if (top < maxCapacity)
        {
            top++;
            arr[top] = val;
        }
    }

    public int pop()
    {
        if (top >= 0)
        {
            top--;
            return arr[top+1];
        }

        return -1;
    }

    public boolean isEmpty()
    {
        if (top == -1)
            return true;
        return false;
    }
}
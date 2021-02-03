public class Stack
{
    private char[] dataArr;

    private int top;

    public Stack()
    {
        dataArr = new char[255];
        top = -1;
    }

    public void push(char data)
    {
        top++;
        dataArr[top] = data;
    }

    public char pop()
    {
        if (top != -1)
        {
            top--;
            return dataArr[top+1];
        }

        return 0;
    }

    public boolean isEmpty()
    {
        if (top == -1)
            return true;
        return false;
    }

    public int length()
    {
        return top + 1;
    }
}
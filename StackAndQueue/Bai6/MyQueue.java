public class MyQueue
{
    private int[] queue;

    private int rear;
    private int front;

    public MyQueue()
    {
        rear = 0;
        front = -1;
        queue = new int[255];
    }

    public void enqueue(int val)
    {
        front++;
        queue[front] = val;
    }

    public int dequeue()
    {
        if (rear > front)
            return -1;

        rear++;
        return queue[rear-1];
    }

    public boolean isEmpty()
    {
        if (rear > front)
            return true;

        return false;
    }
}
public class MyStack 
{
    private int topIndex;

    private Node headNode;

    public MyStack()
    {
        topIndex = 0;
        headNode = new Node();
    }

    public void push(Node newNode)
    {
        newNode.nextNode = headNode.nextNode;
        headNode.nextNode = newNode;
        topIndex++;
    }

    public void showAll()
    {
        if (topIndex == 0)
        {
            System.out.println("Stack rong");
            return;
        }

        Node temp = headNode.nextNode;

        while (temp != null)
        {
            System.out.println(temp.data);
            temp = temp.nextNode;
        }
    }

    public Node pop()
    {
        if (topIndex == 0)
        {
            System.out.println("Stack rong");
            return null;
        }

        Node result = headNode.nextNode;

        headNode.nextNode = headNode.nextNode.nextNode;
        topIndex--;
        return result;
    }

    /**
     * Find Node with specific data in Stack
     * @param data data to find
     * @return position of that Node, -1 if not found
     */
    public int findNode(int data)
    {
        if (topIndex == 0)
        {
            return -1;
        }

        Node temp = headNode.nextNode;
        int count = 0;
        while (temp != null)
        {
            count++;
            if (temp.data == data)
            {
                return count;
            }
            temp = temp.nextNode;
        }

        return -1;
    }
}

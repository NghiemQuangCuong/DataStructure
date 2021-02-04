public class Queue
{
    private Node frontNode;
    private Node rearNode;
    private int size;

    public Queue()
    {
        frontNode = new Node();
        rearNode = new Node();
        size = 0;
    }

    public void enqueue(Node node)
    {
        if (size == 0)
        {
            frontNode.nextNode = node;
            rearNode.nextNode = node;
            size++;
        }
        else
        {
            node.nextNode = frontNode.nextNode;
            node.nextNode.previousNode = node;
            frontNode.nextNode = node;
            size++;
        }
    }

    public Node dequeue()
    {
        if (size == 0)
        {
            System.out.println("Quere rong");
            return null;
        }

        Node result = rearNode.nextNode;
        rearNode.nextNode = rearNode.nextNode.previousNode;
        if (rearNode.nextNode != null)
            rearNode.nextNode.nextNode = null;
        size--;
        return result;
    }

    public void showAll()
    {
        if (size == 0)
        {
            System.out.println("Queue rong");
            return;
        }

        Node temp = frontNode.nextNode;
        while (temp != null)
        {
            System.out.println(temp.data);
            temp = temp.nextNode;
        }
    }

    public Node getFirstNode()
    {
        if (size == 0)
        {
            System.out.println("Queue rong");
            return null;
        }
        return rearNode.nextNode;
    }

    /**
     * Find node with specific data in queue
     * @return position of that Node from rearNode, if not found return -1
     */
    public int findNodePosition(int data)
    {
        if (size == 0)
            return -1;

        int count = 0;
        Node temp = rearNode.nextNode;
        while (temp != null)
        {
            if (temp.data == data)
                return count;
            temp = temp.previousNode;
            count++;
        }

        return -1;
    }
}
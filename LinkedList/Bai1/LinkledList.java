import java.util.Scanner;

public class LinkledList 
{
    private class Node
    {
        public int data;
        public Node next_Node;

        public Node(int val)
        {
            data = val;
        }
    }

    private Node head;

    public LinkledList()
    {
        head = new Node(0);
    }

    public void show()
    {
        Node temp = head;
        while (temp.next_Node != null)
        {
            System.out.println(temp.next_Node.data);
            temp = temp.next_Node;
        }
    }
    
    public void add(int val)
    {
        Node nodeToAdd = new Node(val);
        if (head.next_Node == null)
        {
            head.next_Node = nodeToAdd;
        }
        else
        {
            Node temp = head.next_Node;
            while (temp.next_Node != null)
            {
                temp = temp.next_Node;
            }
            temp.next_Node = nodeToAdd;
        }
    }

    public void deleteFirstElement()
    {
        if (head.next_Node == null)
        {
            System.out.println("Err: List is empty");
        }
        else
        {
            Node temp = head.next_Node;
            head = null;
            System.gc();
            head = temp;
        }
    }

    public void deleteUserInputElement()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("================");
        System.out.print("Nhap phan tu muon xoa: ");
        int val = sc.nextInt();

        Node tempFirst = head;
        Node temp = head.next_Node;
        while (temp != null)
        {
            if (temp.data == val)
            {
                Node tempNode = temp.next_Node;
                tempFirst.next_Node = temp.next_Node;
                temp = null;
                System.gc();
                temp = tempNode;
            }
            else
            {
                tempFirst = tempFirst.next_Node;
                temp = temp.next_Node;
            }
        }
        sc.close();
    }

    public int findFirstElement(int val)
    {
        int count = 0;
        boolean flag = false;
        Node temp = head.next_Node;
        while (temp != null)
        {
            if (temp.data == val)
            {
                flag = true;
                break;
            }
            count++;
            temp = temp.next_Node;
        }

        if (flag)
        {
            return count;
        }
        else
        {
            return -1;
        }
    }

    public int maxElement()
    {
        int max = Integer.MIN_VALUE;

        Node temp = head.next_Node;
        while (temp != null)
        {
            if (max < temp.data)
            {
                max = temp.data;
            }
            temp = temp.next_Node;
        }

        return max;
    }



}



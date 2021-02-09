import java.util.ArrayList;

public class Node 
{
    public int number;
    public ArrayList<Integer> path; 
    public ArrayList<Node> children;



    public Node()
    {
        path = new ArrayList<Integer>();
        children = new ArrayList<Node>();
    }

    public Node(int _number, ArrayList<Node> _children)
    {
        number = _number;
        children = _children;
        path = new ArrayList<Integer>();
    }

    public void updatePath(ArrayList<Integer> _path)
    {
        path = _path;
    }
}

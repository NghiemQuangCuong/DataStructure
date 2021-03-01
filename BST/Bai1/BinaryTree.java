public class BinaryTree 
{
    private Node rootNode;
    private int height;

    public BinaryTree()
    {
    }

    private Node insert(Node root, int val, int heightCount)
    {
        if (root == null)
        {
            root = new Node(val);
            if (heightCount > height)
                height = heightCount;
            return root;
        }

        heightCount++;
        if (val < root.key)
            root.left = insert(root.left, val, heightCount);
        else   
            root.right = insert(root.right, val, heightCount);
        return root;
    }

    public void insertNode(Node nodeToAdd)
    {
        rootNode = insert(rootNode, nodeToAdd.key, 0);
    }

    private void NLR(Node root)
    {
        if (root != null)
            System.out.print(root.key + " ");

        if (root.left != null)
            NLR(root.left);
        if (root.right != null)
            NLR(root.right);
    }

    private void LRN(Node root)
    {
        if (root.left != null)
            LRN(root.left);
        if (root.right != null)
            LRN(root.right);

        if (root != null)
            System.out.print(root.key + " ");
    }

    public void NLRTraversing()
    {
        NLR(rootNode);
    }

    public void LRNTraversing()
    {
        LRN(rootNode);
    }

    public void LNR(Node root)
    {
        if (root.left != null)
            LNR(root.left);

        if (root.left == null && root.right == null && root != null)
            System.out.print(root.key + " ");

        if (root.right != null)
            LNR(root.right);
    }

    public void printLeafNode()
    {
        LNR(rootNode);
    }

    public int treeHeight()
    {
        return height;
    }

    public void deleteNode(int val)
    {
        rootNode = findAndDelete(rootNode, val);
    }

    private Node maxLeft(Node root)
    {
        if (root.right != null)
            return maxLeft(root.right);
        
        return root;
    }

    private Node deleteMaxLeft(Node root)
    {
        if (root.right != null)
            root.right = deleteMaxLeft(root.right);
        else if (root.right == null)
        {
            if (root.left != null)
                root = root.left;
            else 
                root = null;
        }
        return root;
    }

    private Node findAndDelete(Node root, int val)
    {
        if (root.key == val)
        {
            if (root.left == null && root.right == null)
            {
                root = null;
                return root;
            }
            else if (root.left != null && root.right != null)
            {
                root.key = maxLeft(root.left).key;
                root.left = deleteMaxLeft(root.left);
                return root;
            }
            else if (root.left != null)
            {
                root = root.left;
                return root;
            }
            else
            {
                root = root.right;
                return root;
            }
        }

        if (val < root.key)
            root.left = findAndDelete(root.left, val);
        else
            root.right = findAndDelete(root.right, val);

        return root;
    }
}

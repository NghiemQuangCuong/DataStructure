public class BinaryTree
{
    private Node rootNode;

    public BinaryTree()
    {

    }

    private Node insert(Node root, int val)
    {
        if (root == null)
        {
            root = new Node(val);
            return root;
        }

        if (val < root.key)
            root.left = insert(root.left, val);
        else
            root.right = insert(root.right, val);

        return root;
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

    private void LNR(Node root)
    {
        if (root.left != null)
            LNR(root.left);

        if (root != null)
            System.out.print(root.key + " ");
        
        if (root.right != null)
            LNR(root.right);
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

    private boolean binaryTreeSearch(Node root, int val)
    {
        if (root == null)
            return false;

        if (root.key == val)
            return true;

        if (val < root.key)
            return binaryTreeSearch(root.left, val);
        else
            return binaryTreeSearch(root.right, val);   
    }

    private Node deleteMaxLeft(Node root)
    {
        if (root.right != null)
        {
            root.right = deleteMaxLeft(root.right);
            return root;
        }
        else
        {
            if (root.left != null)
            {
                root = root.left;
                return root;
            }
            else
            {
                root = null;
                return root;
            }
        }
    }

    private int findMaxLeft(Node root)
    {
        if (root.right == null)
            return root.key;
        else
            return findMaxLeft(root.right);
    }

    private Node deleteElement(Node root, int val)
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
                root.key = findMaxLeft(root.left);
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
                root =  root.right;
                return root;
            }
        }

        if (val < root.key)
        {
            root.left = deleteElement(root.left, val);
            return root;
        }
        else
        {
            root.right = deleteElement(root.right, val);
            return root;
        }
    }

    private int LRNLeaf(Node root)
    {
        if (root.left == null && root.right == null)
            return 1;
        else if (root.left != null && root.right != null)
        {
            return LRNLeaf(root.left) + LRNLeaf(root.right);
        }
        else if (root.right != null)
        {
            return LRNLeaf(root.right);
        }
        else
        {
            return LRNLeaf(root.left);
        }
    }

    private int LRNHeight(Node root)
    {
        if (root.left == null && root.right == null)
            return 0;
        else
        if (root.left != null && root.right != null)
            return 1 + Math.max(LRNHeight(root.left), LRNHeight(root.right));
        else 
        if (root.left != null)
            return 1 + LRNHeight(root.left);
        else
            return 1 + LRNHeight(root.right);
    }

    public void insertNode(int val)
    {

        rootNode = insert(rootNode, val);
    }

    public void NLRTraverse()
    {
        NLR(rootNode);
    }

    public void LNRTraverse()
    {
        LNR(rootNode);
    }

    public void LRNTraverse()
    {
        LRN(rootNode);
    }

    public boolean findNode(int val)
    {
        return binaryTreeSearch(rootNode, val);
    }

    public void deleteNode(int val)
    {
        rootNode = deleteElement(rootNode, val);
    }

    public int leafCount()
    {
        return LRNLeaf(rootNode);
    }

    public int treeHeight()
    {
        return LRNHeight(rootNode);
    }
}
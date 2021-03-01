class Node
{
    public int key, height;
    public Node left, right;

    public Node(int val)
    {
        key = val;
        height = 1;
    }
}

class MyAVLTree 
{
    Node rootNode;

    int getBalance(Node node)
    {
        if (node == null)
            return 0;

        return height(node.left) - height(node.right);
    }

    int max(int a, int b)
    {
        return a > b ? a : b;
    }

    int height(Node node)
    {
        if (node == null)
            return 0;

        return node.height;
    }

    Node rotateRight(Node root)
    {
        Node rootTemp = root;
        Node rootLeft = root.left;
        if (rootLeft == null) return root;
        rootTemp.left = rootLeft.right;
        rootLeft.right = rootTemp;

        // update height after rotate
        rootTemp.height = max(height(rootTemp.left), height(rootTemp.right)) + 1;
        rootLeft.height = max(height(rootLeft.left), height(rootLeft.right)) + 1;

        return rootLeft;
    }

    Node rotateLeft(Node root)
    {
        Node rootTemp = root;
        Node rootRight = root.right;
        if (rootRight == null) return root;
        rootTemp.right = rootRight.left;
        rootRight.left = rootTemp;

        // update height after rotate
        rootTemp.height = max(height(rootTemp.left), height(rootTemp.right)) + 1;
        rootRight.height = max(height(rootRight.left), height(rootRight.right)) + 1;

        return rootRight;
    }

    Node insert(Node node, int key)
    {
        // if node is null -> add node
        if (node == null)
            return new Node(key);

        // insert as regular BST
        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node;

        // update height of node after insert
        node.height = max(height(node.left), height(node.right)) + 1;

        // get balance of node 
        int balance = getBalance(node);

        // Cay lech phai
        if (balance < -1)
        {
            // truong hop RR
            if (key > node.right.key)
            {
                node = rotateLeft(node);
            }
            // truong hop RL
            else if (key < node.right.key)
            {
                node.right = rotateRight(node.right);
                node = rotateLeft(node);
            }
        }
        // Cay lech trai
        else if (balance > 1)
        {
            // truong hop LL
            if (key < node.left.key)
            {
                node = rotateRight(node);
            }
            // truong hop LR
            else if (key > node.left.key)
            {
                node.left = rotateLeft(node.left);
                node = rotateRight(node);
            }
        }

        // return node 
        return node;
    }

    Node findMinRight(Node node)
    {
        Node temp = node;

        while (temp.left != null)
            temp = temp.left;

        return temp;
    }

    Node delete(Node node, int key)
    {
        // STEP1: delete as regular BST
        if (node == null)
            return node;

        // node to delete on the left side of node
        if (key < node.key)
            node.left = delete(node.left, key);
        // node to delete on the right side of node
        else if (key > node.key)
            node.right = delete(node.right, key);
        // node to delete is the current node
        else
        {
            if (node.left == null || node.right == null)
            {
                if (node.left == null && node.right != null)
                    node = node.right;
                else if (node.right == null && node.left != null)
                    node = node.left;
                else
                    node = null; 
            }
            else
            {
                // find minimum Node on the right of current node
                Node minRightNode = findMinRight(node.right);

                node.key = minRightNode.key;

                // delete minimum Node on the right of current node
                node.right = delete(node.right, minRightNode.key);
            }
        }

        if (node == null)
            return node;

        // STEP2: update height of current node
        node.height = max(height(node.left), height(node.right)) + 1;

        // STEP3: get balance of current node
        int balance = getBalance(node);

        // truong hop cay lech phai (R)
        if (balance < -1)
        {
            // truong hop RR
            if (getBalance(node.right) <= 0)
            {
                node = rotateLeft(node);
            }
            // truong hop RL
            else 
            {
                node.right = rotateRight(node.right);
                node = rotateLeft(node);
            }
        }
        // truong hop cay lech trai (L)
        else if (balance > 1)
        {
            // truong hop LL
            if (getBalance(node.left) >= 0)
            {
                node = rotateRight(node);
            }
            // truong hop LR
            else
            {
                node.left = rotateLeft(node.left);
                node = rotateRight(node);
            }
        }
        return node;
    }

    void LRNBrowse(Node node)
    {
        if (node.left != null)
            LRNBrowse(node.left);
        if (node.right != null)
            LRNBrowse(node.right);

        if (node != null)
            System.out.print(node.key + " ");
    }

    public static void main(String[] args)
    {
        MyAVLTree avl = new MyAVLTree();

        avl.rootNode = avl.insert(avl.rootNode, 10);
        avl.rootNode = avl.insert(avl.rootNode, 20);
        avl.rootNode = avl.insert(avl.rootNode, 30);
        avl.rootNode = avl.insert(avl.rootNode, 40);
        avl.rootNode = avl.insert(avl.rootNode, 50);
        avl.rootNode = avl.insert(avl.rootNode, 25);

        avl.LRNBrowse(avl.rootNode);
        System.out.println();

        avl.rootNode = avl.delete(avl.rootNode, 20);
        avl.rootNode = avl.delete(avl.rootNode, 25);
        avl.rootNode = avl.delete(avl.rootNode, 10);
        
        avl.LRNBrowse(avl.rootNode);
        System.out.println();
    }
}

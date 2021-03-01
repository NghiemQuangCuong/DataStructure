public class MainP
{
    public static void main(String[] args)
    {
        int[] arr = {5, 3, 7, 9, 8, 11, 6, 20, 19, 37, 25, 21, 15, 12};
        /**
         * Vi day la ket qua duyet LRN cua cay BST, cho nen phan tu cuoi cung
         * se la Node Root. Ta se xay dung cay BST tu ket qua tren bang cach
         * di nguoc lai tu phan tu cuoi ve phan tu dau.
         */

        BinaryTree myBinaryTree = new BinaryTree();

        for (int i = arr.length - 1; i >= 0; i--)
        {
            Node temp = new Node(arr[i]);
            myBinaryTree.insertNode(temp);
        }

        myBinaryTree.NLRTraversing();
        System.out.println();
        myBinaryTree.LRNTraversing();
        System.out.println();
        myBinaryTree.printLeafNode();
        System.out.println();
        System.out.println("Height of Tree: " + myBinaryTree.treeHeight());
        //System.out.println("AAA");
        myBinaryTree.deleteNode(12);
        myBinaryTree.LRNTraversing();
        System.out.println();
    }
}
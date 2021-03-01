import java.util.Scanner;

public class MainP 
{
    public static void drawMenu()
    {
        Scanner sc = new Scanner(System.in);
        boolean stop = false;
        BinaryTree myBST = new BinaryTree();
        while (!stop)
        {
            System.out.println("=====Chuong trinh quan ly cay nhi phan=====");
            System.out.println("-------------------------------------------");
            System.out.println("0. Thoat chuong trinh");
            System.out.println("1. Them 1 phan tu vao cay");
            System.out.println("2. Duyet cay theo NLR");
            System.out.println("3. Duyet cay theo LNR");
            System.out.println("4. Duyet cay theo LRN");
            System.out.println("5. Tim phan tu tren cay");
            System.out.println("6. Xoa 1 phan tu tren cay");
            System.out.println("7. In so nut la");
            System.out.println("8. In chieu cao cua cay");
            System.out.println("Lua chon: ");
            String inputUser = sc.nextLine();
            switch (inputUser)
            {
                case "0":
                    stop = true;
                    break;
                case "1":
                {
                    System.out.println("Nhap phan tu (int): ");
                    int input = sc.nextInt();
                    sc.nextLine();
                    myBST.insertNode(input);
                    break;
                }
                
                case "2":
                {
                    myBST.NLRTraverse();
                    break;
                }
                
                case "3":
                {
                    myBST.LNRTraverse();
                    break;
                }

                case "4":
                {
                    myBST.LRNTraverse();
                    break;
                }

                case "5":
                {
                    System.out.println("Nhap phan tu can tim kiem: ");
                    int input = sc.nextInt();
                    sc.nextLine();
                    if (myBST.findNode(input))
                        System.out.println("Tim thay!");
                    else
                        System.out.println("Khong tim thay!");
                    break;
                }

                case "6":
                {
                    System.out.println("Nhap phan tu can xoa: ");
                    int input = sc.nextInt();
                    sc.nextLine();
                    myBST.deleteNode(input);
                    break;
                }
                    
                case "7":
                {
                    System.out.println("So nut la: " + myBST.leafCount());
                    break;
                }

                case "8":
                {
                    System.out.println("Chieu cao cua cay: " + myBST.treeHeight());
                    break;
                }

                default:
                {
                    System.out.println("Unknown command");
                    break;
                }
            }
        }
        sc.close();
    }
    public static void main(String[] args)
    {
        //int[] arr = {15, 5, 2, 9, 13, 16, 17, 22, 4, 18, 1, 19, 23, 11};
        drawMenu();
    }   
}

import java.util.Scanner;

public class Main 
{
    public static Scanner sc = new Scanner(System.in);
    public static LinkledList myList = new LinkledList();

    public static void runMenu()
    {
        boolean stop = true;

        while (stop)
        {
            System.out.println("================================");
            System.out.println("CHUONG TRINH QUAN LY LINKED LIST");
            System.out.println("================================");
            System.out.println("1. Them phan tu moi");
            System.out.println("2. Xoa phan tu Dau Tien");
            System.out.println("3. Xoa phan tu co gia tri tuy y");
            System.out.println("4. In vi tri dau tien phat hien");
            System.out.println("5. In gia tri lon nhat trong list");
            System.out.println("6. Hien thi list");
            System.out.println("7. Thoat chuong trinh");
            System.out.println("================================");
            System.out.print("Your choice: ");
            String userInput = sc.next();
            switch (userInput)
            {
                case "1":
                    System.out.println("Nhap gia tri can them vao (int)");
                    int val1 = sc.nextInt();
                    myList.add(val1);
                    break;
                case "2":
                    myList.deleteFirstElement();
                    System.out.println("Da xoa phan tu dau tien!");
                    break;
                case "3":
                    myList.deleteUserInputElement();
                    break;
                case "4":
                    System.out.print("Nhap gia tri can tim kiem:");
                    int val4 = sc.nextInt();
                    int result4 = myList.findFirstElement(val4);
                    if (result4 == -1)
                    {
                        System.out.println("Khong tim thay gia tri can tim");
                    }
                    else
                    {
                        System.out.println("Vi tri dau tien tim thay: " + result4);
                    }
                    break;
                case "5":
                    System.out.println("Gia tri lon nhat trong trong list: " + myList.maxElement());
                    break;
                case "6":
                    myList.show();
                    break;
                case "7":
                    stop = false;
                    break;
                default:
                    System.out.println("Unknown input");
                    break;
            }
        }
    }

    public static void main(String[] args) 
    {
        runMenu();
    }
}

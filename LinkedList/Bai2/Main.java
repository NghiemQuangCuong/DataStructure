
import java.util.Scanner;

public class Main 
{
    private static Scanner sc = new Scanner(System.in);
    private static SVList myList = new SVList();

    private static void runMenu()
    {
        boolean isStop = false;

        while (!isStop)
        {
            System.out.println("=========================");
            System.out.println("     Student Manager     ");
            System.out.println("=========================");
            System.out.println("0. Thoat chuong trinh");
            System.out.println("1. Nhap danh sach hoc vien");
            System.out.println("2. Xuat danh sach hoc vien");
            System.out.println("3. Liet ke hoc vien co diem trung binh cao nhat");
            System.out.println("4. Dem so luong hoc vien nam");
            System.out.println("5. Tim thong tin cua hoc vien theo ma so");
            System.out.println("6. Tim thong tin hoc vien theo ten");
            System.out.println("7. Chinh sua thong tin hoc vien theo ma so");
            System.out.println("8. Xoa 1 hoc vien theo ma so");
            System.out.println("9. Sap xep danh sach tang dan theo diem trung binh");
            System.out.println("-------------------------");
            System.out.print("Your choice: ");
            String userInput = sc.next();
            switch (userInput)
            {
                case "1":
                    {
                        System.out.println("========================");
                        System.out.println("    Them hoc vien moi   ");
                        System.out.print("Nhap ma so hoc vien: ");
                        sc.nextLine();
                        String maSo = sc.nextLine();
                        System.out.print("Nhap ho ten hoc vien: ");
                        String hoTen = sc.nextLine();
                        System.out.print("Nhap gioi tinh hoc vien (Nam/Nu): ");
                        String gioiTinh = sc.nextLine();
                        System.out.print("Nhap diem trung binh cua hoc vien (0 - 10): ");
                        float diemTrungBinh = sc.nextFloat();
                        myList.addSV(maSo, hoTen, gioiTinh, diemTrungBinh);
                    }
                    break;

                case "2":
                    {
                        System.out.println("=======Danh sach cac sinh vien=======");
                        myList.showAll();
                    }
                    break;

                case "3":
                    {
                        System.out.println("=====Sinh Vien co diem trung binh cao nhat=====");
                        myList.showSVWithMaxPoint();
                    }
                    break;

                case "4":
                    {
                        System.out.println("=====So luong Hoc Vien co gioi tinh Nam=====");
                        System.out.println(myList.maleSVNumber());
                    }
                    break;

                case "5":
                    {
                        System.out.println("=====Tim sinh vien theo ma so=====");
                        System.out.print("Nhap ma so sinh vien can tim: ");
                        sc.nextLine();
                        String id = sc.nextLine();
                        myList.printSVWithSpecificID(id);
                    }
                    break;

                case "6":
                    {
                        System.out.println("=====Tim sinh vien theo ten=====");
                        System.out.print("Nhap ten cua sinh vien can tim: ");
                        sc.nextLine();
                        String name = sc.nextLine();
                        myList.printSVWithSpecificName(name);
                    }
                    break;

                case "7":
                    {
                        System.out.println("=====Chinh sua thong tin hoc vien theo ma so=====");
                        System.out.print("Nhap ID hoc vien can chinh sua: ");
                        sc.nextLine();
                        String id = sc.nextLine();
                        myList.changeSVPointWithSpecificID(id);
                    }
                    break;

                case "8":
                    {
                        System.out.println("=====Xoa hoc vien theo ma so=====");
                        System.out.print("Nhap ID hoc vien can xoa: ");
                        sc.nextLine();
                        String id = sc.nextLine();
                        System.out.print("Ban co chac chan muon xoa hoc vien (Y/N): ");
                        if (myList.printSVWithSpecificID(id))
                        {
                            String decision = sc.next();
                            while (!decision.equals("Y") && !decision.equals("N"))
                            {
                                System.out.print("Ban co chac chan muon xoa hoc vien (Y/N): ");
                                decision = sc.next();
                            }

                            if (decision.equals("Y"))
                            {
                                myList.deleteSVWithSpecificID(id);
                                System.out.println("Xoa thanh cong");
                            }
                        }
                    }
                    break;
                
                case "9":
                    {
                        myList.sortListWithAscendingPoint();
                        System.out.println("Sap xep thanh cong");
                    }
                    break;

                case "0":
                    isStop = true;
                    break;

                default:
                    System.out.println("Unknown decision");
                    break;       
            }
        }
    }


    public static void main(String[] args) 
    {
        runMenu();
        
    }   
}

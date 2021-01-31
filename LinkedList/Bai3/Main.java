import java.util.InputMismatchException;
import java.util.Scanner;

public class Main 
{
    private static void runMenu()
    {
        Scanner sc = new Scanner(System.in);
        boolean isStop = false;
        ListHangHoa myList = new ListHangHoa();

        while (!isStop)
        {
            System.out.println("=====Chuong Trinh quan ly hang hoa tu file=====");
            System.out.println("-----------------------------------------------");
            System.out.println("0. Thoat Chuong Trinh");
            System.out.println("1. Them hang hoa");
            System.out.println("2. Xuat danh sach hang hoa");
            System.out.println("3. Liet ke hang hoa co don gia tren mot trieu");
            System.out.println("4. Liet ke hang hoa co don gia cao nhat");
            System.out.println("5. Tim thong tin hang hoa theo mau sac");
            System.out.println("6. Tim thong tin hang hoa theo kich co");
            System.out.println("7. Tim thong tin hang hoa theo mau sac va kich co");
            System.out.println("8. Tim thong tin hang hoa theo khoang gia");
            System.out.println("9. Cap nhat thong tin hang hoa theo ma so");
            System.out.println("10. Xoa hang hoa theo ma so");
            System.out.println("11. Sap xep danh sach theo gia tien tang dan");
            System.out.println("12. Luu danh sach vao file");
            System.out.println("-----------------------------------------------");
            System.out.print("Your choice: ");
            String userInput = sc.nextLine();
            switch (userInput)
            {
                case "0":
                    System.out.println("Hay chac chan ban da luu danh sach moi vao file (Muc 12)");
                    System.out.println("Du lieu chua duoc luu se bi mat");   
                    String decision = "";
                    do 
                    {
                        System.out.print("Tiep tuc thoat? (Y/N): ");
                        decision = sc.nextLine();
                    } while (!decision.equals("Y") && !decision.equals("N"));
                    if (decision.equals("N"))
                        break;

                    isStop = true;
                    break;
                case "1":
                    myList.addGoodsFromConsole();
                    break;
                case "2":
                    myList.showConsole();
                    break;
                case "3":
                    myList.showGoodsWithPriceMoreThanOneMillion();
                    break;
                case "4":
                    myList.showGoodsWithHighestPrice();
                    break;
                case "5":
                    {
                        System.out.print("Nhap mau sac can tim kiem");
                        String mauSac = sc.nextLine();
                        myList.findGoodsWithSpecificColor(mauSac);
                    }
                    break;
                case "6":
                    {
                        try 
                        {
                            System.out.print("Nhap kich co can tim kiem: ");
                            double kichCo = sc.nextDouble();
                            sc.nextLine();
                            myList.findGoodsWithSpecificSize(kichCo);
                        } catch (InputMismatchException ex) 
                        {
                            System.out.println("Data mismatch");
                        }
                    }
                    break;
                case "7":
                    {
                        try 
                        {
                            System.out.print("Nhap mau sac can tim kiem: ");
                            String mauSac = sc.nextLine();
                            System.out.print("Nhap kich co can tim kiem: ");
                            double kichCo = sc.nextDouble();
                            sc.nextLine();
                            myList.findGoodsWithSpecificSizeAndColor(kichCo, mauSac);
                        } catch (InputMismatchException ex) 
                        {
                            System.out.println("Data mismatch");
                        }
                    }
                    break;
                case "8":
                    {
                        try 
                        {
                            System.out.print("Nhap gia thap nhat: ");
                            double minPrice = sc.nextDouble();
                            System.out.print("Nhap gia cao nhat: ");
                            double maxPrice = sc.nextDouble();
                            sc.nextLine();
                            myList.findGoodsWithPriceRange(minPrice, maxPrice);
                        } catch (InputMismatchException ex) 
                        {
                            System.out.println("Data mismatch");
                        }
                    }
                    break;
                case "9":
                    {
                        System.out.print("Nhap ma so hang hoa muon thay doi: ");
                        String maSo = sc.nextLine();
                        myList.changeNodeWithSpecificID(maSo);
                    }
                    break;
                case "10":
                    {
                        System.out.print("Nhap ma so hang hoa muon xoa: ");
                        String maSo = sc.nextLine();
                        myList.removeNodeWithSpecificID(maSo);
                    }
                    break;
                case "11":
                    myList.sortListWithAscendingPrice();
                    break;
                case "12":
                    myList.writeDataToFile();
                    break;

                default:
                    System.out.println("Unknown command");
                    break;
            }
        }

        sc.close();
    }

    public static void main(String[] args) 
    {
        runMenu();
    }
}

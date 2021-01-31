import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ListHangHoa 
{
    private File dataFile = new File("data.txt");
    private Scanner sc = new Scanner(System.in);
    private Scanner fsc;
   

    private class Node 
    {
        public String maSo;
        public String tenHang;
        public String mauSac;
        public double kichCo;
        public double donGia;

        public Node next_Node;

        public Node()
        {

        }

        public Node(String maSo, String tenHang, String mauSac, double kichCo, double donGia) 
        {
            while (isDuplicate(maSo))
            {
                System.out.println("----ID_"+maSo+"_IS_CREATED_BEFORE----");
                System.out.print("Enter new ID for "+tenHang+": ");
                maSo = sc.nextLine();
            }
            
            this.maSo = maSo;
            this.tenHang = tenHang;
            this.mauSac = mauSac;


            while (kichCo < 0)
            {
                System.out.println("----DATA_MISMATCH_WITH_ID_"+maSo+"----");
                System.out.println("Kich co truoc do: "+kichCo);
                System.out.print("Nhap lai kich co: ");
                kichCo = sc.nextDouble();
            }
            this.kichCo = kichCo;

            while (donGia < 0)
            {
                System.out.println("----DATA_MISMATCH_WITH_ID_"+maSo+"----");
                System.out.println("Don gia truoc do: "+donGia);
                System.out.print("Nhap lai don gia: ");
                donGia = sc.nextDouble();
            }
            this.donGia = donGia;

        }

    }

    private Node head_Node;
    private int soLuong;

    public ListHangHoa()
    {
        head_Node = new Node();
        soLuong = 0;
        readDataFromFile();
    }

    private boolean isDuplicate(String maSo)
    {
        Node temp = head_Node.next_Node;
        while (temp != null)
        {
            if (temp.maSo.equals(maSo))
                return true;

            temp = temp.next_Node;
        }

        return false;
    }

    private void printInfo(Node node)
    {
        System.out.printf("%7s -- %20s -- %7s -- %10.2f -- %10.2f\n", node.maSo, node.tenHang, node.mauSac, node.kichCo, node.donGia);
    }

    private void readDataFromFile()
    {
        try 
        {
            fsc = new Scanner(dataFile);
        } catch (FileNotFoundException ex) 
        {
            System.out.println("File not Found!");
            return;
        }

        int n = fsc.nextInt();
        fsc.nextLine();
        for (int i = 0; i < n; i++)
        {
            String maSo = fsc.nextLine();
            String tenHang = fsc.nextLine();
            String mauSac = fsc.nextLine();
            double kichCo = Double.parseDouble(fsc.nextLine());
            double donGia = Double.parseDouble(fsc.nextLine());

            Node newNode = new Node(maSo, tenHang, mauSac, kichCo, donGia);
            addNode(newNode);
        }
        fsc.close();
    }

    private void addNode(Node nodeToAdd)
    {
        soLuong++;
        if (head_Node.next_Node == null)
        {
            head_Node.next_Node = nodeToAdd;
        }
        else
        {
            nodeToAdd.next_Node = head_Node.next_Node;
            head_Node.next_Node = nodeToAdd;
        }
    }

    public void addGoodsFromConsole()
    {
        System.out.println("-----Them Hang Hoa-----");
        System.out.print("Nhap ma so: ");
        String maSo = sc.nextLine();
        System.out.print("Nhap ten hang: ");
        String tenHang = sc.nextLine();
        System.out.print("Nhap mau sac: ");
        String mauSac = sc.nextLine();
        double kichCo, donGia;
        try 
        {
            System.out.print("Nhap kich co: ");
            kichCo = sc.nextDouble();
            System.out.print("Nhap don gia: ");
            donGia = sc.nextDouble();
        } catch (InputMismatchException ex) 
        {
            System.out.println("Err data mismatch");
            return;
        }
        sc.nextLine();
        Node newNode = new Node(maSo, tenHang, mauSac, kichCo, donGia);
        addNode(newNode);
    }

    public void showConsole()
    {
        Node temp = head_Node.next_Node;
        if (temp == null)
        {
            System.out.println("Danh Sach Trong!");
            return;
        }
        System.out.println("=====DANH_SACH_HANG_HOA=====");
        while (temp != null)
        {
            printInfo(temp);
            temp = temp.next_Node;
        }
    }

    public void showGoodsWithPriceMoreThanOneMillion()
    {
        Node temp = head_Node.next_Node;
        boolean flag = false;
        if (temp == null)
        {
            System.out.println("Danh Sach Trong!");
            return;
        }
        while (temp != null)
        {
            if (temp.donGia > 1000000f)
            {
                printInfo(temp);
                flag = true;
            }
                
            temp = temp.next_Node;
        }

        if (!flag)
            System.out.println("Khong tim thay hang hoa");
    }

    public void showGoodsWithHighestPrice()
    {
        Node temp = head_Node.next_Node;
        Node result = temp;
        if (temp == null)
        {
            System.out.println("Danh sach trong!");
            return;
        }
        double max = Double.MIN_VALUE;
        while (temp != null)
        {
            if (max < temp.donGia)
            {
                max = temp.donGia;
                result = temp;
            }
            temp = temp.next_Node;
        }

        System.out.println("====Hang Hoa Gia Cao Nhat=====");
        printInfo(result);
    }

    public void findGoodsWithSpecificSize(double size)
    {
        Node temp = head_Node.next_Node;
        boolean flag = false;
        if (temp == null)
        {
            System.out.println("Danh sach rong!");
            return;
        }
        System.out.println("=====HANG_HOA_CO_KICH_CO_"+size+"=====");
        while (temp != null)
        {
            if (temp.kichCo == size)
            {
                flag = true;
                printInfo(temp);
            }
            temp = temp.next_Node;
        }
        if (!flag)
            System.out.println("Khong tim thay hang hoa");
    }

    public void findGoodsWithSpecificColor(String color)
    {
        Node temp = head_Node.next_Node;
        boolean flag = false;
        if (temp == null)
        {
            System.out.println("Danh Sach Rong!");
            return;
        }
        System.out.println("=====HANG_HOA_CO_MAU_SAC_"+color+"=====");
        while (temp != null)
        {
            if (temp.mauSac.equals(color))
            {
                flag = true;
                printInfo(temp);
            }
            temp = temp.next_Node;
        }

        if (!flag)
            System.out.println("Khong tim thay hang hoa");
    }

    public void findGoodsWithSpecificSizeAndColor(double size, String color)
    {
        Node temp = head_Node.next_Node;
        if (temp == null)
        {
            System.out.println("Danh sach rong!");
            return;
        }
        boolean flag = false;

        System.out.printf("=====HANG_HOA_CO_KICH_CO_%.2f_&_MAU_SAC_%s=====\n", size, color);
        while (temp != null)
        {
            if (temp.mauSac.equals(color) && temp.kichCo == size)
            {
                flag = true;
                printInfo(temp);
            }
            temp = temp.next_Node;
        }

        if (!flag)
            System.out.println("Khong tim thay hang hoa");
    }

    public void findGoodsWithPriceRange(double minPrice, double maxPrice)
    {
        Node temp = head_Node.next_Node;
        if (temp == null)
        {
            System.out.println("Danh sach rong!");
            return;
        }
        

        boolean flag = false;
        System.out.printf("=====HANG_HOA_CO_GIA_TU_%.2f_TO_%.2f=====\n", minPrice, maxPrice);
        if (minPrice > maxPrice)
        {
            System.out.println("Gia thap nhat lon hon gia cao nhat");
            return;
        }
        while (temp != null)
        {
            if (temp.donGia >= minPrice && temp.donGia <= maxPrice)
            {
                flag = true;
                printInfo(temp);
            }
            temp = temp.next_Node;
        }
        if (!flag)
            System.out.println("Khong tim thay hang hoa");
    }

    public void changeNodeWithSpecificID(String maSo)
    {
        Node temp = head_Node.next_Node;
        boolean flag = false;
        if (temp == null)
        {
            System.out.println("Danh sach Rong!");
            return;
        }

        System.out.println("=====THAY_DOI_HANG_HOA_VOI_ID_"+maSo+"=====");
        while (temp != null)
        {
            if (temp.maSo.equals(maSo))
            {
                flag = true;
                printInfo(temp);
                System.out.println("---------------------");
                String newMaSo;
                do
                {
                    System.out.print("Nhap ma so can thay doi: ");
                    newMaSo = sc.nextLine();
                } while (isDuplicate(newMaSo));
                System.out.print("Nhap ten hang can thay doi: ");
                String newTenHang = sc.nextLine();
                System.out.print("Nhap mau sac can thay doi: ");
                String newMauSac = sc.nextLine();
                double newKichCo;
                do 
                {
                    System.out.print("Nhap kich co can thay doi: ");
                    newKichCo = sc.nextDouble();    
                } while (newKichCo < 0);
                double newDonGia;
                do 
                {
                    System.out.print("Nhap don gia can thay doi: ");
                    newDonGia = sc.nextDouble();    
                } while (newDonGia < 0);
                sc.nextLine(); /////////////////////////////////////
                temp.maSo = newMaSo;
                temp.tenHang = newTenHang;
                temp.mauSac = newMauSac;
                temp.kichCo = newKichCo;
                temp.donGia = newDonGia;
                break;
            }

            temp = temp.next_Node;
        }

        if (!flag)
            System.out.println("Khong tim thay hang hoa");
    }

    public void removeNodeWithSpecificID(String maSo)
    {
        Node temp = head_Node.next_Node;
        Node firstTemp = head_Node;
        boolean flag = false;
        String decision = "";
        if (temp == null)
        {
            System.out.println("Danh sach rong!");
            return;
        }

        while (temp != null)
        {
            if (temp.maSo.equals(maSo))
            {
                System.out.println("Ban co that su muon xoa hang hoa nay: ");
                printInfo(temp);
                do
                {
                    System.out.print("Y/N: ");
                    decision = sc.nextLine();
                } while (!decision.equals("Y") && !decision.equals("N"));
                if (decision.equals("N"))
                    break;

                flag = true;
                firstTemp.next_Node = temp.next_Node;
                temp = null;
                System.gc();
                System.out.println("Da xoa hang hoa voi ma so "+maSo+" thanh cong");
                break;
            }
            else
            {
                temp = temp.next_Node;
                firstTemp = firstTemp.next_Node;
            }
        }

        if (!flag && decision.equals("Y"))
            System.out.println("Khong tim thay hang hoa");
    }

    public void sortListWithAscendingPrice()
    {
        Node temp = head_Node.next_Node;
        Node firstTemp = head_Node;
        if (temp == null)
        {
            System.out.println("Danh sach rong");
            return;
        }

        boolean moreSort = true;
        while (moreSort)
        {
            moreSort = false;
            temp = head_Node.next_Node;
            firstTemp = head_Node;

            while (temp.next_Node != null)
            {
                if (temp.donGia > temp.next_Node.donGia)
                {
                    moreSort = true;

                    Node node1 = temp;
                    Node node2 = temp.next_Node;
                    node1.next_Node = temp.next_Node.next_Node;
                    firstTemp.next_Node = node2;
                    firstTemp.next_Node.next_Node = node1;

                    temp = node1;
                    firstTemp = firstTemp.next_Node;
                }
                else
                {
                    temp = temp.next_Node;
                    firstTemp = firstTemp.next_Node;
                }
            }
        }
        System.out.println("Sap xep thanh cong theo gia tien tang");
    }

    public void writeDataToFile()
    {
        PrintWriter wrt;
        try 
        {
            wrt = new PrintWriter("data.txt");
        } catch (FileNotFoundException ex) 
        {
            System.out.println("Khong tim thay file");
            return;
        }

        wrt.println(soLuong);
        Node temp = head_Node.next_Node;

        while (temp != null)
        {
            wrt.println(temp.maSo);
            wrt.println(temp.tenHang);
            wrt.println(temp.mauSac);
            wrt.println(temp.kichCo);
            wrt.println(temp.donGia);
            temp = temp.next_Node;
        }

        System.out.println("Da luu du lieu thanh cong!");
        wrt.close();
    }
}
import java.util.Scanner;

public class SVList
{
    private Scanner sc = new Scanner(System.in);

    private class Node
    {
        public String maSo;
        public String hoTen;
        public String gioiTinh;
        public float diemTrungBinh;

        public Node next_Node;

        public Node()
        {

        }
        public Node(String _maSo, String _hoTen, String _gioiTinh, float _diemTrungBinh)
        {
            maSo = _maSo;
            hoTen = _hoTen;

            while (true)
            {
                if (_gioiTinh.equals("Nam") || _gioiTinh.equals("Nu"))
                {
                    gioiTinh = _gioiTinh;
                    break;
                }
                else
                {
                    System.out.print("Xin nhap lai gioi tinh (Nam/Nu): ");
                    _gioiTinh = sc.nextLine();
                }
            }

            while (_diemTrungBinh < 0f || _diemTrungBinh >10f)
            {
                System.out.print("Xin nhap lai diem trung binh (0-10): ");
                _diemTrungBinh = sc.nextFloat();
            }
            diemTrungBinh = _diemTrungBinh;
        }

        public void setMaSo(String _maSo)
        {
            maSo = _maSo;
        }
        
        public void setHoTen(String _hoTen)
        {
            hoTen = _hoTen;
        }

        public void setGioiTinh(String _gioiTinh)
        {
            gioiTinh = _gioiTinh;
        }

        public void setDiemTrungBinh(float _diemTrungBinh)
        {
            diemTrungBinh = _diemTrungBinh;
        }
    }
    
    private Node head_Node;

    private void printInfo(Node node)
    {
        System.out.printf("%8s - %25s - %4s - %.2f\n", node.maSo, node.hoTen, node.gioiTinh, node.diemTrungBinh);
    }

    private void changeNodeOnInputUser(Node node)
    {
        System.out.print("Enter id to change: ");
        String newID = sc.nextLine();
        System.out.print("Enter name to change: ");
        String newName = sc.nextLine();
        System.out.print("Enter gender to change: ");
        String newGender = sc.nextLine();
        System.out.print("Enter point to change: ");
        float newDTB = sc.nextFloat();

        node.setMaSo(newID);
        node.setHoTen(newName);
        while (!newGender.equals("Nam") && !newGender.equals("Nu"))
        {
            System.out.print("Xin nhap lai gioi tinh (Nam/Nu): ");
            newGender = sc.nextLine();
        }
        node.setGioiTinh(newGender);
        while (newDTB < 0f || newDTB >10f)
        {
            System.out.print("Xin nhap lai diem trung binh (0-10): ");
            newDTB = sc.nextFloat();
        }
        node.setDiemTrungBinh(newDTB);
    }

    public SVList()
    {
        head_Node = new Node();
    }

    public void addSV(String _maSo, String _hoTen, String _gioiTinh, float _diemTrungBinh)
    {
        Node newSV = new Node(_maSo, _hoTen, _gioiTinh, _diemTrungBinh);

        if (head_Node.next_Node == null)
        {
            head_Node.next_Node = newSV;
        }
        else
        {
            newSV.next_Node = head_Node.next_Node;
            head_Node.next_Node = newSV;
        }

        System.out.println("Da them sinh vien thanh cong");
    }

    public void showAll()
    {
        Node temp = head_Node.next_Node;

        while (temp != null)
        {
            printInfo(temp);
            temp = temp.next_Node;
        }
    }

    public void showPointOver5()
    {
        Node temp = head_Node.next_Node;

        while (temp != null)
        {
            if (temp.diemTrungBinh >= 5)
            {
                printInfo(temp);
            }
            temp = temp.next_Node;
        }
    }

    public void showSVWithMaxPoint()
    {
        Node temp = head_Node.next_Node;
        Node result = temp;
        float maxPoint = Float.MIN_VALUE;

        while (temp != null)
        {
            if (temp.diemTrungBinh > maxPoint)
            {
                maxPoint = temp.diemTrungBinh;
                result = temp;
            }
            temp = temp.next_Node;
        }
        if (result != null)
            printInfo(result);
    }

    public int maleSVNumber()
    {
        int result = 0;
        Node temp = head_Node.next_Node;

        while (temp != null)
        {
            if (temp.gioiTinh.equals("Nam"))
                result++;

            temp = temp.next_Node;
        }

        return result;
    }

    public boolean printSVWithSpecificID(String id)
    {
        boolean found = false;
        Node temp = head_Node.next_Node;

        while (temp != null)
        {
            if (temp.maSo.equals(id))
            {
                printInfo(temp);
                found = true;
            }
            temp = temp.next_Node;
        }

        if (!found)
        {
            System.out.println("Khong tim thay sinh vien voi ma so "+id);
            return false;
        }
        else
            return true;
    }

    public void printSVWithSpecificName(String name)
    {
        boolean found = false;
        Node temp = head_Node.next_Node;

        while (temp != null)
        {
            if (temp.hoTen.equals(name))
            {
                printInfo(temp);
                found = true;
            }

            temp = temp.next_Node;
        }

        if (!found)
            System.out.println("Khong tim thay sinh vien voi ten "+name);
    }

    public void changeSVPointWithSpecificID(String id)
    {
        boolean found = false;
        Node temp = head_Node.next_Node;

        while (temp != null)
        {
            if (temp.maSo.equals(id))
            {
                System.out.println("----------Change this SV----------");
                printInfo(temp);
                changeNodeOnInputUser(temp);
                found = true;
                break;
            }
            temp = temp.next_Node;
        }

        if (!found)
            System.out.println("Khong tim thay sinh vien voi id "+id);
    }

    public void deleteSVWithSpecificID(String id)
    {
        Node lastTemp = head_Node.next_Node;
        Node firstTemp = head_Node;

        while (lastTemp != null)
        {
            if (lastTemp.maSo.equals(id))
            {
                firstTemp.next_Node = lastTemp.next_Node;
                lastTemp = null;
                System.gc();
                break;
            }
            lastTemp = lastTemp.next_Node;
            firstTemp = firstTemp.next_Node;
        }
    }

    public void sortListWithAscendingPoint()
    {
        boolean swapAble = true;
        if (head_Node.next_Node == null)
        {
            System.out.println("Danh sach khong co SV de sap xep");
            return;
        }

        while (swapAble)
        {
            swapAble = false;
            Node firstTemp = head_Node;
            Node temp = head_Node.next_Node;

            while (temp.next_Node != null)
            {
                
                if (temp.diemTrungBinh > temp.next_Node.diemTrungBinh)
                {
                    swapAble = true;
                    Node node1 = temp.next_Node;
                    Node node2 = temp;
                    node2.next_Node = node1.next_Node;
                    firstTemp.next_Node = node1;
                    firstTemp.next_Node.next_Node = node2;
                    //////////////////////////////////////
                    temp = node2;
                    firstTemp = firstTemp.next_Node;
                }
                else
                {
                    firstTemp = firstTemp.next_Node;
                    temp = temp.next_Node;
                }
                
            }
        }
    }

}
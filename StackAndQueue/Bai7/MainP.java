import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainP 
{

    // Chuong trinh kiem tra 2 dinh tren do thi co lien thong voi nhau hay khong 
    // (co ton tai duong cac canh noi 2 diem do voi nhau)

    public static void main(String[] args) throws FileNotFoundException
    {
        File file = new File("input.txt");
        Scanner sc = new Scanner(file);

        int n = sc.nextInt();

        int[][] arr = new int[n+1][n+1];
        for (int i = 1; i <= n; i++)
        for (int j = 1; j <= n; j++)
            arr[i][j] = sc.nextInt();

        int nodeA = 1;
        int nodeB = 9;
        
        // visited array
        boolean[] visited = new boolean[n+1];
        for (int i = 1; i <= n; i++)
            visited[i] = false;

        // zone array
        int[] zone = new int[n+1];

        MyStack stack = new MyStack(n+1);
        int countZone = -1;

        for (int i = 1; i <= n; i++)
        {
            if (!visited[i]) 
            {
                countZone++;
                stack.push(i);
                while (!stack.isEmpty())
                {
                    int curNode = stack.pop();
                    visited[curNode] = true;
                    zone[curNode] = countZone;
                    for (int j = 1; j <= n; j++)
                    {
                        if (arr[curNode][j] == 1 && !visited[j])
                        {
                            stack.push(j);
                        }
                    }
                }
            }
        }

        if (zone[nodeA] == zone[nodeB])
            System.out.println("Same zone");
        else
            System.out.println("Not same zone");
    }
}

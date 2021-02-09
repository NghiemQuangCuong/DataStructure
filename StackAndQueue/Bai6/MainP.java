import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainP {
    public static void main(String[] args) throws FileNotFoundException
    {
        File file = new File("input.txt");
        Scanner sc = new Scanner(file);
        
        int n;
        n = sc.nextInt();

        int[][] arr = new int[n+1][n+1];
        String[] path = new String[n+1];
        path[1] = "1";

        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                arr[i][j] = sc.nextInt();
            }
        }

        MyQueue myQueue = new MyQueue();
        myQueue.enqueue(1);
        int nodeToFind = 6;

        String result = "";
        while (!myQueue.isEmpty())
        {
            int curNode = myQueue.dequeue();
            if (curNode == nodeToFind)
            {
                result = path[curNode];
                break;
            }

            for (int j = 1; j <= n; j++)
            {
                if (arr[curNode][j] == 1)
                {
                    path[j] = path[curNode] + "," + String.valueOf(j);
                    myQueue.enqueue(j);
                }
            }
        }

        if (result.equals(""))
        {
            System.out.println("Cannot find path");
        }
        else
        {
            System.out.println(result);
        }

        sc.close();
    }


    
}

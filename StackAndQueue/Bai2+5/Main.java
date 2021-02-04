import java.util.InputMismatchException;
import java.util.Scanner;

public class Main 
{
    public static void runMenu()
    {
        Scanner sc = new Scanner(System.in);
        Queue myQueue = new Queue();
        boolean isStop = false;

        while (!isStop)
        {
            System.out.println("=====Queue Manager=====");
            System.out.println("0. Exit program");
            System.out.println("1. Enqueue element into queue");
            System.out.println("2. Dequeue element into queue");
            System.out.println("3. Show all element of queue");
            System.out.println("4. Show first element of queue");
            System.out.println("5. Find an element in queue");
            System.out.print("Your choice: ");
            String userInput = sc.nextLine();
            switch (userInput)
            {
                case "0":
                    isStop = true;
                    break;
                case "1":
                    {
                        int data = 0;
                        try 
                        {
                            System.out.print("Enter data to add (integer only): ");
                            data = sc.nextInt();
                        } catch (InputMismatchException ex) 
                        {
                            System.out.println("Input data mismatch");
                        }
                        sc.nextLine();
                        myQueue.enqueue(new Node(data));
                    }
                    break;   
                case "2":
                    myQueue.dequeue();
                    break;
                case "3":
                    System.out.println("--------------");
                    myQueue.showAll();
                    break;
                case "4":
                    System.out.println("First element: " + myQueue.getFirstNode().data);
                    break;
                case "5":
                    {
                        int data = 0;
                        System.out.print("Enter data of element to find (integer only): ");
                        try 
                        {
                            data = sc.nextInt();
                            sc.nextLine();
                        } catch (InputMismatchException ex)
                        {
                            System.out.println("Data mismatch");
                        }
                        int result = myQueue.findNodePosition(data);
                        if (result == -1)
                            System.out.println("Not found in queue");
                        else
                            System.out.println("Position: " + result);    
                    }    
                    break;
                default:
                    System.out.println("Unknown command");
                    break;
            }
        }
    }

    public static void main(String[] args)
    {
        runMenu();
    }
    
}

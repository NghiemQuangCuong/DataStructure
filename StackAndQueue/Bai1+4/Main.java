import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
    public static void runMenu()
    {
        Scanner scanner = new Scanner(System.in);

        boolean isStop = false;
        MyStack myStack = new MyStack();

        while (!isStop)
        {
            System.out.println("=====Stack Manager=====");
            System.out.println("------------------------------------");
            System.out.println("0. Exit");
            System.out.println("1. Add new Node to stack");
            System.out.println("2. Pop Node out of stack");
            System.out.println("3. Show all Nodes in stack");
            System.out.println("4. Find Node with specific data input in stack");
            System.out.print("Your decision: ");
            String inputUser = scanner.nextLine();
            switch (inputUser)
            {
                case "0":
                    isStop = true;
                    break;
                case "1":
                    System.out.println("--------------------");
                    try 
                    {
                        System.out.print("Enter data to push to stack (interger only): ");
                        int data = scanner.nextInt();
                        scanner.nextLine();
                        myStack.push(new Node(data));
                        System.out.println("Node Added");

                    } catch (InputMismatchException ex) 
                    {
                        System.out.println("Input Type Mismatch");
                    }
                    break;
                case "2":
                    System.out.println("--------------------");

                    // Do Some thing with this Node
                    Node popNode = myStack.pop();
                    // ^^^^^^^^^^^^^^^^^^^^^^^^^^

                    System.out.println("Node popped");
                    break;
                case "3":
                    System.out.println("--------------------");
                    myStack.showAll();
                    break;
                case "4":
                    System.out.println("--------------------");
                    try 
                    {
                        System.out.print("Enter data to find (integer only): ");
                        int data = scanner.nextInt();
                        scanner.nextLine();
                        int result = myStack.findNode(data);
                        if (result == -1)
                        {
                            System.out.println("Cannot find a Node with given data");
                        }
                        else
                        {
                            System.out.println("Found!");
                            System.out.println("Position of that Node is " + result);
                        }
                    } catch (InputMismatchException ex) 
                    {
                        System.out.println("Input type mismatch");
                    }
                    break;
                default:
                    System.out.println("Unknown Command");
                    break;
            }
        }

        scanner.close();
    }

    public static void main(String[] args)
    {
        runMenu();
    }
}
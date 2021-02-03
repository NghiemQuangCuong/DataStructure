public class Main 
{
    private static String convertToBinary(int number)
    {
        if (number < 1)
            return "0";

        Stack stack = new Stack();

        while (number != 0)
        {
            stack.push((char)(number%2 + '0'));
            number /= 2;
        }

        String result = "";
        int count = stack.length() % 4;

        while (!stack.isEmpty())
        {
            result += stack.pop();
            count--;
            if (count % 4 == 0)
                result += ' ';
        }

        return result;
    }

    private static String convertToHex(int number)
    {
        if (number < 1)
            return "0";

        Stack stack = new Stack();
        while (number != 0)
        {
            int temp = number % 16;

            if (temp >= 0 && temp <=9)
            {
                stack.push((char)(temp + '0'));
            }
            else // 10-A 11-B 12-C 13-D 14-E 15-F 
            {
                stack.push((char)(temp + '7'));
            }
            number /= 16;
        }

        String result = "";
        while (!stack.isEmpty())
        {
            result += stack.pop();
        }

        return result;
    }

    public static void main(String[] args)
    {
        String resultBinary = convertToBinary(9999);
        String resultHex = convertToHex(9999);

        System.out.println("Binary: " + resultBinary);
         System.out.println("Hex: " + resultHex);
    }    
}

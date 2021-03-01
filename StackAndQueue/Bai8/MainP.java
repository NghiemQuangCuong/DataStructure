import java.util.Stack;


/**
 * Dung stack de tim ket qua cua mot bieu thuc trung to
 */
public class MainP
{
    
    private static Stack<String> number = new Stack<>();
    private static Stack<String> operator = new Stack<>();

    public static String compareOperator(String A, String B)
    {
        if (A.equals("+") || A.equals("-"))
            return "<";
        else if (B.equals("+") || B.equals("-"))
            return ">";
        else
            return "<";
    }

    public static void calculate(String op)
    {
        boolean flag = false;
        String numB = number.pop();
        String numA = number.pop();

        if (op.equals(")"))
        {
            // flag = true;
            op = operator.pop();
        };

        switch (op)
        {
            case "+":
                {
                    int result = Integer.parseInt(numA) + Integer.parseInt(numB);
                    number.push(String.valueOf(result));    
                }  
                break;
            case "-":
                {
                    int result = Integer.parseInt(numA) - Integer.parseInt(numB);
                    number.push(String.valueOf(result));    
                }  
                break;
            case "*":
                {
                    int result = Integer.parseInt(numA) * Integer.parseInt(numB);
                    number.push(String.valueOf(result));    
                }  
                break;
            case "/":
                {
                    int result = Integer.parseInt(numA) / Integer.parseInt(numB);
                    number.push(String.valueOf(result));    
                }  
                break;
            case "^":
                {
                    int result = (int)(Math.pow(Integer.parseInt(numA),Integer.parseInt(numB)));
                    number.push(String.valueOf(result));    
                }  
                break;
        }

        // if (flag && operator.peek().equals("("))
        //     operator.pop();
    }

    public static void main(String[] args)
    {
        String expression = "(3+(5*(8+5-3-1-3-4*7*4*3*(3-3+1+3*6/3)*2+1)-7)*9)-(6+2)/2-5";
        expression = expression + ".";

        String temp = "";
        for (int i = 0; i < expression.length()-1; i++)
        {
            temp += expression.charAt(i);
            if (expression.charAt(i+1) >= '0' && expression.charAt(i+1) <= '9' &&
                expression.charAt(i) >= '0' && expression.charAt(i) <= '9')
                continue;
            else
            {
                if (temp.equals("+") || temp.equals("-") || temp.equals("*") || temp.equals("/") ||
                    temp.equals("(") || temp.equals(")") || temp.equals("^"))
                {
                    if (operator.isEmpty() && !temp.equals("("))
                        operator.push(temp);
                    else if (temp.equals("(") || temp.equals(")"))
                    {
                        if (temp.equals("("))
                            operator.push(temp);
                        else
                        {
                            while (!operator.isEmpty() && !operator.peek().equals("("))
                                calculate(temp);

                            if (operator.peek().equals("("))
                                operator.pop();
                        }
                    }
                    else if (operator.peek().equals("(") || compareOperator(temp, operator.peek()).equals(">"))
                    {
                        operator.push(temp);
                    }
                    else
                    {
                        while (!operator.isEmpty() && !operator.peek().equals("(") && compareOperator(temp, operator.peek()).equals("<"))
                        {
                            calculate(operator.pop());
                        }
                        operator.push(temp);
                    }
                }
                else
                {
                    number.push(temp);
                }
            }
            temp = "";
        }

         String last = operator.pop();
         calculate(last);

        System.out.println(number.peek());
    }
}
import java.io.*;
public class Main {

    static StackPerso<Integer> valStk = new StackPerso<>(5);
    static StackPerso<String> opStk = new StackPerso<>(5);

    public static void main(String[] args) {

        try {
            calculateFromFile("input.txt", "output.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void calculateFromFile(String inputFile, String outputFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        FileWriter writer = new FileWriter(outputFile);

        String line;
        writer.write("Here are the results of the operations: \n");
        while ((line = reader.readLine()) != null) {
            writer.write(line + " = ");
            int result = evaluateExpression(line);
            writer.write(result + "\n");
        }

        reader.close();
        writer.close();
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static int evaluateExpression(String expression)
    {
        String [] tokens = expression.split(" ");
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];

            if(isNumeric(token))
            {
                valStk.push(Integer.parseInt(token));
            } else if (token.equals("(")) {
                opStk.push(token);
            } else if (token.equals(")")) {
                while (opStk.size()>0 && !opStk.peek().equals("("))
                {
                    performOperation();
                }
                opStk.pop();
            } else if (isOperator(token)){

                String op = token;
                while (opStk.size()>0 && precedence(opStk.peek())<= precedence(op)&& !opStk.peek().equals("("))
                {
                    performOperation();
                }
                opStk.push(op);
            }
            else
            {
                continue;
            }
        }
        while (opStk.size() > 0) {
            performOperation();
        }
        return valStk.pop();

    }

    public static boolean isOperator(String operator)
    {
        return operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")
                || operator.equals("^") || operator.equals(">")||operator.equals("≥")  ||operator.equals("≤") ||operator.equals("<")||
                operator.equals("==")||operator.equals("!=");
    }

    private static int precedence(String operator) {
        switch (operator) {
            case "(":
            case ")":
                return 1;
            case "^":
                return 2;
            case "*":
            case "/":
                return 3;
            case "+":
            case "-":
                return 4;
            case ">":
            case "≥":
            case "≤":
            case "<":
                return 5;
            case "==":
            case "!=":
                return 6;
            default:
                return 1000000000;
        }
    }

    public static void performOperation() {
        String operator = opStk.pop();
        int b = valStk.pop();
        int a = valStk.pop();

        switch (operator) {
            case "+":
                valStk.push(a + b);
                break;
            case "-":
                valStk.push(a - b);
                break;
            case "*":
                valStk.push(a * b);
                break;
            case "/":
                valStk.push(a / b);
                break;
            case "^":
                valStk.push((int) Math.pow(a, b));
                break;
            case ">":
                valStk.push(a > b ? 1 : 0);
                break;
            case "≥":
                valStk.push(a >= b ? 1 : 0);
                break;
            case "≤":
                valStk.push(a <= b ? 1 : 0);
                break;
            case "<":
                valStk.push(a < b ? 1 : 0);
                break;
            case "==":
                valStk.push(a == b ? 1 : 0);
                break;
            case "!=":
                valStk.push(a != b ? 1 : 0);
                break;
        }
    }
}
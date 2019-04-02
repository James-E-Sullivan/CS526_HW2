import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InfixEvaluation {

    /**
     * Evaluates arithmetic expression using stacks, returns int value
     * @param expression: String with valid arithmetic expression
     * @return operandStack.pop(): int evaluation of expression returned
     */
    public static int evaluate(String expression){
        final String opening = "(";                             // String matching opening parenthesis
        final String closing = ")";                             // String matching closing parenthesis
        final String operatorString = "+-*/";                   // String of possible operators

        LinkedStack <Integer> operandStack = new LinkedStack<>();    // stack for operand integers
        LinkedStack <String> operatorStack = new LinkedStack<>();    // stack for operators

        String[] splitExpression = expression.split(" ");       // splits expression string by spaces

        for (String s : splitExpression){

            if (s.equals(opening))                // check if String is an opening parenthesis (does nothing)
                continue;
            else if (operatorString.contains(s))    // check if String is an operator
                operatorStack.push(s);
            else if (closing.contains(s)){          // check if String is a closing parenthesis
                int operand2 = operandStack.pop();       // top of operand stack is 2nd operand
                int operand1 = operandStack.pop();       // next in operand stack is 1st operand

                String operator = operatorStack.top();      // Assigns most recent operator in operatorStack
                switch(operator){
                    case "+":
                        operatorStack.pop();                                // pops most recent operator
                        operandStack.push(operand1 + operand2);     // pushes evaluated value to operandStack
                        break;
                    case "-":
                        operatorStack.pop();
                        operandStack.push(operand1 - operand2);
                        break;
                    case "*":
                        operatorStack.pop();
                        operandStack.push(operand1 * operand2);
                        break;
                    case "/":
                        operatorStack.pop();
                        operandStack.push(operand1 / operand2);
                        break;
                }
            }
            else{     // assuming valid input string, this will be a number
                operandStack.push(Integer.parseInt(s));     // converts String to int & pushes to operand stack
            }


        }
        return (operandStack.pop());                    // after all calculations, returns final value
    }

    public static void main(String[] args) {
        String lineFromFile;

        try{
            FileInputStream expressionFile = new FileInputStream("resources/infix_expressions.txt");
            Scanner fileInput = new Scanner(expressionFile);

            while (fileInput.hasNextLine()){                // iterates through lines in txt file
                lineFromFile = fileInput.nextLine();        // assumes all lines are valid

                // Prints expression and output of expression from each line of file
                System.out.println("The value of " + lineFromFile + " is " + evaluate(lineFromFile));
            }
        }

        // fileNoteFoundException error
        catch (FileNotFoundException ex){
            System.err.println(ex.getMessage() + ": File not found. Exiting.");
            ex.printStackTrace();
            System.exit(0);
        }

        // all other exceptions, catch-all
        catch (Exception ex){
            System.err.println(ex.getMessage());
            ex.printStackTrace();
            System.exit(0);
        }
    }
}

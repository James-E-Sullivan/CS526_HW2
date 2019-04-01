public class InfixEvaluation {

    public static int evaluate(String expression){
        final String opening = "(";                             // String matching opening parenthesis
        final String closing = ")";                             // String matching closing parenthesis
        final String operatorString = "+-*/";                   // String of possible operators

        LinkedStack <String> buffer = new LinkedStack<>();      // stack for opening parentheses
        LinkedStack <Integer> operandStack = new LinkedStack<>();    // stack for operand integers
        LinkedStack <String> operatorStack = new LinkedStack<>();    // stack for operators

        String[] splitExpression = expression.split(" ");       // splits expression string by spaces

        for (String c : splitExpression){

            if (opening.contains(c))                // check if String is an opening parenthesis
                buffer.push(c);
            else if (operatorString.contains(c))    // check if String is an operator
                operatorStack.push(c);
            else if (closing.contains(c)){          // check if String is a closing parenthesis
                int operand2 = operandStack.pop();       // top of operand stack is 2nd operand
                int operand1 = operandStack.pop();       // next in operand stack is 1st operand

                String operator = operatorStack.top();      // Assigns most recent operator in operatorStack
                switch(operator){
                    case "+":
                        operatorStack.pop();
                        operandStack.push(operand1 + operand2);
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

                buffer.pop();
            }
            else                                    // assumes String is a number
                operandStack.push(Integer.parseInt(c));  // converts to int & pushes to operand stack
        }
        return (operandStack.pop());
    }

    public static void main(String[] args) {
        String s1 = "( ( 2 + 5 ) * 3 )";
        System.out.println(evaluate(s1));

        String s2 = "( ( ( 3 + 2 ) * 3 ) - ( 6 / 2 ) )";
        System.out.println(evaluate(s2));

        String s3 = "( ( ( 7 - 5 ) * 2 ) / (  10 - 8 ) )";
        System.out.println(evaluate(s3));
    }
}

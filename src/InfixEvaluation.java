public class InfixEvaluation {

    public static int evaluate(String expression){
        final String opening = "(";
        final String closing = ")";
        final String operatorString = "+-*/";

        LinkedStack <Character> buffer = new LinkedStack<>();
        LinkedStack <Integer> operand = new LinkedStack<>();
        LinkedStack <Character> operator = new LinkedStack<>();

        for (char c : expression.toCharArray()){
            /*
            System.out.println(c);     // for testing only, delete
            System.out.println("\nBuffer: " + buffer.toString());
            System.out.println("operand: " + operand.toString());
            System.out.println("operator: " + operator.toString() + "\n");
            */

            if (opening.indexOf(c) != -1)
                buffer.push(c);
            else if (operatorString.indexOf(c) != -1)
                operator.push(c);
            else if (closing.indexOf(c) != -1){
                if (operator.top().equals('+')){
                    operator.pop();
                    operand.push(operand.pop() + operand.pop());
                }else if (operator.top().equals('-')){
                    operator.pop();
                    operand.push(operand.pop() - operand.pop());
                }else if (operator.top().equals('*')){
                    operator.pop();
                    operand.push(operand.pop() * operand.pop());
                }else if (operator.top().equals('/')){
                    operator.pop();
                    operand.push(operand.pop() / operand.pop());
                }

                /*
                else if (operator.pop().equals('-'))
                    operand.push(operand.pop() - operand.pop());
                else if (operator.pop().equals('*'))
                    operand.push(operand.pop() * operand.pop());
                else if (operator.pop().equals('/'))
                    operand.push(operand.pop() / operand.pop());
                */

                buffer.pop();
            }
            else
                operand.push(Character.getNumericValue(c));
        }
        return (operand.pop());
    }

    public static void main(String[] args) {
        String s1 = "((2+5)*3)";
        System.out.println(evaluate(s1));

        String s2 = "(((3+2)*3)-(6/2))";
        System.out.println(evaluate(s2));

        String s3 = "(((7-5)*2)/(10-8))";
        System.out.println(evaluate(s3));
    }
}

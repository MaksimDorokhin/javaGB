/*
 * ((((1+2)+3)*4)/(5+((6*7)/10)))
 */
package Seminars.S4T1CalculateExpression;

import java.util.Stack;

public class S4T1 {

    public static void main(String[] args) {
        String expression = "((((1+2)+3)*4)/(5+((6*7)/10)))";

        Stack<Double> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {

            if (Character.isDigit(expression.charAt(i))) { // Заполнение операндов
                String temp = Character.toString(expression.charAt(i));

                for (int j = i + 1; j < expression.length(); j++) {
                    if (Character.isDigit(expression.charAt(j))) {
                        temp += expression.charAt(j);
                        i = j; // Перемещаемся по внешнему циклу дальше для исключения проверки части уже
                               // добавленного числа
                    } else
                        break;
                }
                operands.push(Double.parseDouble(temp));
            }

            // Заполнение операторов

            if (expression.charAt(i) == '+' || (expression.charAt(i) == '-') ||
                    (expression.charAt(i) == '*') || (expression.charAt(i) == '/'))
                operators.push(expression.charAt(i));

            // Проверяем встретилась ли закрывающаяся скобка, если да - выполняем операцию
            // с крайними значениями операнда и оператора в соответствующих стеках.
            // Результат кладем в стек операндов.

            if (expression.charAt(i) == ')') {
                switch (operators.pop()) {
                    case '+' -> operands.push(operands.pop() + operands.pop());
                    case '-' -> operands.push(-operands.pop() + operands.pop());
                    case '*' -> operands.push(operands.pop() * operands.pop());
                    case '/' -> operands.push(1 / operands.pop() * operands.pop());
                }
            }
        }
        System.out.printf("Ответ: %f\n", operands.pop());
    }

}

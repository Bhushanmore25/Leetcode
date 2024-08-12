import java.util.Stack;
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> s = new Stack<>();
        int sum = 0;
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int a = Integer.parseInt(s.pop());
                int b = Integer.parseInt(s.pop());
                switch (token) {
                    case "+":
                        sum = b + a;
                        break;
                    case "-":
                        sum = b - a;
                        break;
                    case "*":
                        sum = b * a;
                        break;
                    case "/":
                        sum = b / a;
                        break;
                    default:
                        break;
                }
                s.push(Integer.toString(sum));
                sum = 0;
            } else {
                s.push(token);
            }
        }
        sum = Integer.parseInt(s.pop());
        return sum;
    }
}
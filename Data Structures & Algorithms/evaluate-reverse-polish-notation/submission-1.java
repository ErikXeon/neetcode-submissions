class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();

        for(String s : tokens) {
            if(!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/")) {
                stack.push(s);
            }
            else {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                switch(s) {
                    case "+":
                        stack.push(String.valueOf(b + a));
                        break;
                    case "-":
                        stack.push(String.valueOf(b - a));
                        break;
                    case "*":
                        stack.push(String.valueOf(b * a));
                        break;
                    case "/":
                        stack.push(String.valueOf(b / a));
                        break;
                }

            }
        }
        return Integer.parseInt(stack.pop());
    }
}

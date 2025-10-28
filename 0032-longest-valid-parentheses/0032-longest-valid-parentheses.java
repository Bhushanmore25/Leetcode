class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stnum = new Stack<>();
        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                st.push('(');
                stnum.push(1);
            } 
            else if (ch == ')') {
                if (!st.isEmpty() && st.peek() == '(') {
                    st.pop();
                    int sum = 1;

                    // merge any valid substring inside
                    while (!stnum.isEmpty() && stnum.peek() != 1 && stnum.peek() != -1)
                        sum += stnum.pop();

                    // pop its '(' marker
                    if (!stnum.isEmpty() && stnum.peek() == 1)
                        stnum.pop();

                    // count this new pair
                    sum += 1;
                    stnum.push(sum);

                    // merge consecutive valid blocks
                    int merged = 0;
                    while (!stnum.isEmpty() && stnum.peek() != 1 && stnum.peek() != -1)
                        merged += stnum.pop();
                    stnum.push(merged);
                } 
                else {
                    // unmatched ')', reset stacks
                    st.clear();
                    stnum.push(-1);
                }
            }
        }

        int maxi = 0;
        while (!stnum.isEmpty()) {
            int val = stnum.pop();
            if (val > 1) maxi = Math.max(maxi, val);
        }
        return maxi;
    }
}
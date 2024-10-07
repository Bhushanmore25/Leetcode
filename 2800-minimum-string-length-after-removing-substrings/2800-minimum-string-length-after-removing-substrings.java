class Solution {
    public int minLength(String s) {
        Stack<Character> st = new Stack<>();  
        int len=0;
        for (int i = 0; i < s.length(); i++) {
            if (st.empty()) {
                st.push(s.charAt(i));
                len++;
            }
            else if ((st.peek()=='A'&& s.charAt(i)=='B')||(st.peek()=='C'&&s.charAt(i)=='D')) {
               st.pop();
               len--;
            }
            else{
                st.push(s.charAt(i));
                len++;
            }
        }
        return len;
    }
}
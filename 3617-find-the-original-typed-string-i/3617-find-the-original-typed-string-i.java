class Solution {
    public int possibleStringCount(String word) {
        Stack<Character> st=new Stack<>();
        int n=word.length();
        int ans=0;
        for(int i=n-1;i>=0;i--)
        {
            if(!st.isEmpty() && st.peek() == word.charAt(i))
            {
                ans++;
            }
            else{
                if (!st.isEmpty()) {
                    st.pop();
                }
                st.push(word.charAt(i));
            }
        }

        return ans+1; 
    }
}
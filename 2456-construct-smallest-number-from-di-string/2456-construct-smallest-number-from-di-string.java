import java.util.Stack;

class Solution {
    public String smallestNumber(String pattern) {
        Stack<Integer> st=new Stack<>();
        int n=pattern.length();
        StringBuilder ans=new StringBuilder();
        for(int i=1;i<=n+1;i++)
        {
            st.push(i);
            if(i == n+1 || pattern.charAt(i-1)=='I' )
            {
                while(!st.isEmpty())
                {
                    ans.append(st.pop());
                }
            }
        }
        return ans.toString();
    }
}

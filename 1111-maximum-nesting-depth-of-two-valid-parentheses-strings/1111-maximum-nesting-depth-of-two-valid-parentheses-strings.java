class Solution {
    public int[] maxDepthAfterSplit(String sq) {
        Stack<Character> st=new Stack<>();
        int a=0,b=0;
        int[] ans=new int[sq.length()];
        for(int i=0;i<sq.length();i++)
        {
            if(sq.charAt(i)=='(')
            {
                if(a<=b) {
                    a+=1;
                    st.push('a');
                    ans[i]=0;
                }
                else{
                    b+=1;
                    ans[i]=1;
                    st.push('b');
                }
            }
            else{
                if(st.pop()=='a') {
                    a-=1;
                    ans[i]=0;
                }
                else {
                    b-=1;
                    ans[i]=1;
                }
            }
        }
        return ans;
    }
}
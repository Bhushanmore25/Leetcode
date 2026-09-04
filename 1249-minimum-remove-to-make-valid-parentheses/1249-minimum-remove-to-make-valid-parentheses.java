class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st=new Stack<>();
        int open=0,close=0;
        StringBuilder str=new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch!=')' && ch!='(') str.append(ch);
            else if(ch=='(')
            {
                str.append(ch);
                open++;
                st.push(str.length()-1);
            }
            else{
                if(close<open){
                    str.append(ch);
                    close++;
                }
            }
        }
        if(open>close)
        {
            while(open>close)
            {
                int idx=st.pop();
                str.deleteCharAt(idx);
                open--;
            }
        }
        return str.toString();
    }
}
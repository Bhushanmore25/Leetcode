class Solution {
    public int scoreOfParentheses(String s) {
        int depth=0,score=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                depth+=1;
            }
            else{
                depth--;
                if(s.charAt(i-1)=='(')
                {
                    score+=(1<<depth);
                }
            }
        }
        return score;
    }
}
// class Solution {
//     public int scoreOfParentheses(String s) {
//         Stack<Integer> st=new Stack<>();
//         int score=0;
//         for(int i=0;i<s.length();i++)
//         {
//             if(s.charAt(i)=='(')
//             {
//                 st.push(score);
//                 score=0;
//             }
//             else{
//                 if(s.charAt(i-1)=='(')
//                 {
//                     score=st.peek()+1;
//                 }
//                 else{
//                     score=st.peek() + 2*score;
//                 }
//                 st.pop();
//             }
//         }
//         return score;
//     }
// }
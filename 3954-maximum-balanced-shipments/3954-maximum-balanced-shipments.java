class Solution {
    public int maxBalancedShipments(int[] weight) {
        Stack<Integer> st=new Stack<>();
        st.push(weight[0]);
        int ans=0;
        for(int i=1;i<weight.length;i++)
        {
            if(st.isEmpty() || st.peek()<weight[i]) st.push(weight[i]);
            else if(st.peek()>weight[i]){
                ans++;
                while(!st.isEmpty()) {
                    System.out.println(st.peek());
                    st.pop();
                }
            }
        }
        return ans;
    }
}
class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        Stack<Long> st = new Stack<>();

        for (int x : nums) {
            long val = x;

            while (!st.isEmpty() && st.peek() == val) {
                st.pop();
                val *= 2;
            }

            st.push(val);
        }

        List<Long> ans=new ArrayList<>();
        while(!st.isEmpty())
        {
            ans.add(0,st.pop());
        }
        return ans;

    }
}
class MinStack {
    Stack<int[]> st;
    public MinStack() {
        st=new Stack<>();
    }
    
    public void push(int value) {
        if(st.size()==0)
        {
            st.push(new int[]{value,value});
            return;
        }
        int[] t=st.peek();
        int min=Math.min(t[1],value);
        st.push(new int[]{value,min});
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        int[] t=st.peek();
        return t[0];
    }
    
    public int getMin() {
        int[] t=st.peek();
        return t[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
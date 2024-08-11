class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] nsl=new int[heights.length];
        int[] nsr=new int[heights.length];
        Stack<Integer> s=new Stack<>();
        for (int i = heights.length-1; i >=0; i--) {
            while (!s.isEmpty() && heights[s.peek()]>=heights[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nsr[i]=heights.length;
            }
            else{
                nsr[i]=s.peek();
            }
            s.push(i);
        }
        s=new Stack<>();
        for (int i = 0; i < nsr.length; i++) {
            while (!s.isEmpty() && heights[s.peek()]>=heights[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nsl[i]=-1;
            }
            else{
                nsl[i]=s.peek();
            }
            s.push(i);
        }
        int largestRectangle=0;
        for (int i = 0; i < nsr.length; i++) {
            int width=nsr[i]-nsl[i]-1;
            int area=heights[i]*width;
            largestRectangle=Math.max(area,largestRectangle);
        }
        return largestRectangle;
    }
}
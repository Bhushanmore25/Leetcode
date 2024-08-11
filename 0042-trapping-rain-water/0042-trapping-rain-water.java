class Solution {
    public int trap(int[] height) {
        int[] leftmax=new int[height.length];
        int[] rightmax=new int[height.length];
        leftmax[0]=height[0];
        int n=height.length;
        rightmax[rightmax.length-1]=height[height.length-1];
        for (int i = 1; i < height.length; i++) {
            if (leftmax[i-1]<height[i]) {
                leftmax[i]=height[i];
            }
            else{
                leftmax[i]=leftmax[i-1];
            }
            if (rightmax[n-i]<height[n-i-1]) {
                rightmax[n-i-1]=height[n-i-1];
            }
            else{
                rightmax[n-i-1]=rightmax[n-i];
            }
        }
        int trappedwater=0;
       for (int i = 0; i < n; i++) {
        int waterLevel=Math.min(leftmax[i], rightmax[i]);
        trappedwater+=waterLevel-height[i];
       }
        return trappedwater;
    }
}
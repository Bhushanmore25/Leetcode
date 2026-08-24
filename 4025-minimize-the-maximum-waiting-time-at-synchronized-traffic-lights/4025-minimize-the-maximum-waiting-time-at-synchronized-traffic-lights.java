class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int max=0;
        for(int i:lights) max=Math.max(max,i);
        int ans=0;
        for(int i:arrivalTime){
            int r=i%period;
            if(r<max) continue;
            else ans=Math.max(ans,(period-r));
        }
        return ans;
    }
}
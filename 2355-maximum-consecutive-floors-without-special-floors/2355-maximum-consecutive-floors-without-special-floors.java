class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        int diff =0,max =0;
        Arrays.sort(special);
        max = Math.max(max, special[0] - bottom);
        for(int i=1;i<special.length;i++)
        {
            diff = special[i]-special[i-1]-1;
            max = Math.max(diff, max);
        }
        return Math.max(max, top - special[special.length-1]);
    }
}
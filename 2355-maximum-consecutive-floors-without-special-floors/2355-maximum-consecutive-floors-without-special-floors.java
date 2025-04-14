class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        if (special.length == top - bottom + 1)
        return 0;
        Arrays.sort(special);
        int max=Math.max(special[0]-bottom , top-special[special.length-1]);
        for(int i=0;i<special.length-1;i++)
        {
            max=Math.max(max , special[i+1]-special[i]-1);
        }
        return max;
    }
}
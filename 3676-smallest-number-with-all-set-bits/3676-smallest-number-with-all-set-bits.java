class Solution {
    public int smallestNumber(int n) {
        int val=1;
        while(val-1 < n)
        {
            val = val * 2;
        }
        return val-1;
    }
}
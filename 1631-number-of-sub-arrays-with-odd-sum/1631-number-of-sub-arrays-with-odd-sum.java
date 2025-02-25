class Solution {
    public int numOfSubarrays(int[] arr) {
        final int MOD = 1_000_000_007;
        int oddCount = 0, evenCount = 1, count = 0; 
        int prefixSum = 0;
        
        for (int num : arr) {
            prefixSum += num;
            if (prefixSum % 2 == 1) {
                count = (count + evenCount) % MOD;  
                oddCount++;
            } else { 
                count = (count + oddCount) % MOD;  
                evenCount++;
            }
        }
        return count;
    }
}
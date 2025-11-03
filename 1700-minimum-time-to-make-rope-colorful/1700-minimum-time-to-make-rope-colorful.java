class Solution {
    public int minCost(String s, int[] neededTime) {
        int totalCost = 0;
        int maxTime = neededTime[0]; 

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                totalCost += Math.min(maxTime, neededTime[i]);
                maxTime = Math.max(maxTime, neededTime[i]);
            } else {
                maxTime = neededTime[i];
            }
        }

        return totalCost;
    }
}
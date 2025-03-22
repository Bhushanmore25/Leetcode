class Solution {
    List<Integer> solveQueries(int[] nums, int[] queries) {
        Map<Integer,Integer> lastSeen = new HashMap<>();
        List<Integer> dist = new ArrayList<>(), ans = new ArrayList<>();
        for(int i = 0, n = nums.length; i < nums.length*2; ++i){
            if(i < n) dist.add(n+1);
            if(lastSeen.containsKey(nums[i % n])){
                int curInd = i % n, prevIndex = lastSeen.get(nums[curInd]) % n;
                dist.set(curInd, Math.min(dist.get(curInd), i - lastSeen.get(nums[curInd])));
                dist.set(prevIndex, Math.min(dist.get(prevIndex), i - lastSeen.get(nums[curInd])));
            }
            lastSeen.put(nums[i % n], i);
        }
        for(int q: queries) ans.add((dist.get(q) >= nums.length)?-1: dist.get(q));
        return ans;
    }
}
class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer,Integer> mp=new HashMap<>();
        for(int i:answers)
            mp.put(i,mp.getOrDefault(i,0)+1);
        int ans=0;
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            int x = entry.getKey();
            int count = entry.getValue(); 

            int groupSize = x + 1;
            int groups = (count + x) / groupSize;
            ans += groups * groupSize;
        } 
        return ans;
    }
}
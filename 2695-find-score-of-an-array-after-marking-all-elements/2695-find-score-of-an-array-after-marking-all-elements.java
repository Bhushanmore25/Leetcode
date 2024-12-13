class Solution {
    public long findScore(int[] nums) {
        ArrayList<Integer> ranking=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
            ranking.add(i);
        ranking.sort((a,b)->{
            if(nums[a]==nums[b]) return Integer.compare(a,b);
            return Integer.compare(nums[a],nums[b]);
        });
        long score=0;
        boolean[] mark=new boolean[nums.length];
        for(int r:ranking)
        {
            if(!mark[r])
            {
                score+=nums[r];
                mark[r]=true;
                if(r-1>=0)
                    mark[r-1]=true;
                if(r+1<nums.length)
                    mark[r+1]=true;
            }
        }
        return score;
    }
}
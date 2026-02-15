class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        int[] freq=new int[101];
        for(int i:bulbs)
        {
            freq[i]++;
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<101;i++)
        {
            if(freq[i]%2!=0) ans.add(i);
        }
        return ans;
    }
}
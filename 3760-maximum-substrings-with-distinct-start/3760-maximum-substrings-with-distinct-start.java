class Solution {
    public int maxDistinct(String s) {
        int[] freq=new int[26];
        int count=0;
        for(char ch:s.toCharArray())
        {
            int idx=ch-'a';
            if(freq[idx]==0) {count++;freq[idx]=1;}
        }
        return count;
    }
}
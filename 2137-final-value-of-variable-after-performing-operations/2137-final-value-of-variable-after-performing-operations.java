class Solution {
    public int finalValueAfterOperations(String[] operations) {
        String s1="--X";
        String s2="X--";
        String s3="++X";
        String s4="X++";
        int ans=0;
        for(String s:operations)
        {
            if(s1.equals(s)|| s2.equals(s)) ans--;
            else ans++;
        }
        return ans;
    }
}
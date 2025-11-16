class Solution {
    public int numSub(String s) {
        int count=0,temp=0,MOD=1000000007;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='1')
            {
                temp=temp+1;
                count=(count+temp)%MOD;
            }
            else{
                temp=0;
            }
        }
        return count;
    }
}
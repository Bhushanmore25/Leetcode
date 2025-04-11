class Solution {
    public int countSymmetricIntegers(int low, int high) {
        if(low>=100 && high<=999) return 0;
        int count=0;
        for(int i=low;i<=high;i++)
        {
            String s=String.valueOf(i);
            int sum1=0,sum2=0;
            if(s.length()%2!=0) continue;
            
            for(int j=0;j<s.length()/2;j++)
            {
                sum1+=(s.charAt(j)-'0');
                sum2+=(s.charAt(s.length()-1-j)-'0');
            }
            if(sum1==sum2) count++;
        }
        return count;
    }
}
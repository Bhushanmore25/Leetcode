class Solution {
    public boolean consecutiveSetBits(int n) {
        int prev=-1,count=0;

        while(n!=0)
        {
            int curr=n%2;
            if(prev==-1)
                prev=curr;
            else
            {
                if(prev==1 && curr==1) count++;
                prev=curr;
            }    
            n/=2;
        }
        return count==1;
    }
}
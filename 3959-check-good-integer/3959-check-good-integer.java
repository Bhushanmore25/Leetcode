class Solution {
    public boolean checkGoodInteger(int n) {
        int sqSum=0,digitSum=0;
        while(n!=0)
        {
            int val=n%10;
            sqSum+=val*val;
            digitSum+=val;
            n/=10;
        }
        return sqSum-digitSum>=50;
    }
}
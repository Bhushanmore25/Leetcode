class Solution {
    public int trailingZeroes(int n) {
        int two=0,five=0;
        for(int i=1;i<=n;i++)
        {
            int curr=i;
            while(curr%2==0){
                curr/=2;
                two++;
            }
            curr=i;
            while(curr%5==0){
                curr/=5;
                five++;
            }
        }
        return Math.min(two,five);
    }
}
class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(num*9<sum) return "";
        StringBuilder s=new StringBuilder();
        // int curr=0;
        for(int i=0;i<num;i++)
        {
            if(sum>=9)
            {
                s.append('9');
                sum-=9;
            }
            else if(sum>=0){
                s.append((char)('0'+sum));
                sum=0;
            }
        }
        return s.toString();
    }
}
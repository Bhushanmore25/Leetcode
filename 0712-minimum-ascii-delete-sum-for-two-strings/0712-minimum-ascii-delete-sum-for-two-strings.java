class Solution {
    public static int helper(String s1,String s2,int[][] dp,int i,int j,int[] prefix,int[] prefix2)
    {
        if(i==s1.length() && j==s2.length()) return 0;
        if(i>=s1.length() || j>=s2.length())
        {
            int total=0;
            if(i<s1.length())
            {   
                total=prefix[i];
            } 
            else{
                total=prefix2[j];
            }
            return total;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)) {
            int sum3=helper(s1,s2,dp,i+1,j+1,prefix,prefix2);
            return dp[i][j]=sum3;    
        }
        int sum1=97 + (s1.charAt(i) - 'a') + helper(s1,s2,dp,i+1,j,prefix,prefix2);
        int sum2=97 + (s2.charAt(j) - 'a') + helper(s1,s2,dp,i,j+1,prefix,prefix2);
        return dp[i][j]=Math.min(sum1,sum2);
    }
    public int minimumDeleteSum(String s1, String s2) {
        int m=s1.length(),n=s2.length();
        int[] prefix=new int[m+1];
        for(int i=m-1;i>=0;i--) prefix[i]=97 + (s1.charAt(i)-'a')+prefix[i+1];  
        int[] prefix2=new int[n+1];
        for(int i=n-1;i>=0;i--) prefix2[i]=97 + (s2.charAt(i)-'a')+prefix2[i+1];  

        int[][] dp=new int[m][n];
        for(int i[]:dp)
            Arrays.fill(i,-1);
        return helper(s1,s2,dp,0,0,prefix,prefix2); 
    }
}
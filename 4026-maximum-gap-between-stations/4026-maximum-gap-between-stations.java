class Solution {
    public int maximumGap(String s, String t) {
        int[] left=new int[s.length()];
        int[] right=new int[t.length()];
        int j=0;
        for(int i=0;i<s.length();i++)
        {
            while(s.charAt(i)!=t.charAt(j)) j++;
            left[i]=j;
            j++;
        }
        j=t.length()-1;
        for(int i=s.length()-1;i>=0;i--)
        {
            while(s.charAt(i)!=t.charAt(j)) j--;
            right[i]=j;
            j--;
        }
        int ans=0;
        for(int i=0;i<s.length()-1;i++) ans=Math.max(ans,right[i+1]-left[i]);
        return ans;
    }
}
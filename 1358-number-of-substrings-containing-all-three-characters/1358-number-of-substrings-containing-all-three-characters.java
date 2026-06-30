class Solution {
    public int numberOfSubstrings(String s) {
        int ans=0;
        int l=0,r=0,n=s.length();
        int count[]=new int[3];
        while(r<n)
        {
            count[s.charAt(r)-'a']++;

            while(count[0] > 0 && count[1] > 0 && count[2] > 0)
            {
                ans+=n-r;
                count[s.charAt(l)-'a']--;
                l++;
            }
            r++;
        }
        return ans;
    }
}
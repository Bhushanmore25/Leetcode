class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans=new ArrayList<>();
        int[] freq=new int[26];
        for(int i=0;i<s.length();i++)
        {
            freq[s.charAt(i)-'a']=i;
        }
        int l=0,r=0,n=s.length(),prev=0;
        int first=0;
        while(r<n)
        {
            r=freq[s.charAt(r)-'a'];
            first++;
            while(l<r)
            {
                r=Math.max(r,freq[s.charAt(l)-'a']);
                l++;
            }
            if(first==1)
            ans.add(r-prev+1);
            else
            ans.add(r-prev);

            prev=r++;
        }
        return ans;
    }
}
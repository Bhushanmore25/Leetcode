class Solution {
    public String smallestSubsequence(String s) {
        int[] freq=new int[26];
        boolean[] vis=new boolean[26];
        for(int i=0;i<s.length();i++)
        {
            freq[s.charAt(i)-'a']=i;
        }
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(vis[ch-'a'])
                continue;
            
            while(ans.length()>0 && ans.charAt(ans.length()-1) > ch && freq[ans.charAt(ans.length()-1)-'a'] > i)
            {
                vis[ans.charAt(ans.length()-1)-'a']=false;
                ans.deleteCharAt(ans.length()-1);
            }
            ans.append(ch);
            vis[ch-'a']=true;
        }
        return ans.toString();
    }
}
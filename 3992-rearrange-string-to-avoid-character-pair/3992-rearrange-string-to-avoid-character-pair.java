class Solution {
    public String rearrangeString(String s, char x, char y) {
        int[] freq=new int[26];
        for(char c:s.toCharArray())
        {
            freq[c-'a']++;
        }
        StringBuilder ans=new StringBuilder();
        while(freq[y-'a']!=0) {
            ans.append(y);
            freq[y-'a']--;
        }
        for(int i=0;i<26;i++)
        {
            while(freq[i]!=0)
            {
                ans.append((char)('a' + i));
                freq[i]--;
            }
        }
        return ans.toString();
    }
}
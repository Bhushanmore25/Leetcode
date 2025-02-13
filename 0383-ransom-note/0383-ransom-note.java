class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freq1=new int[26];
        // int[] freq2=new int[26];
        for(char ch:ransomNote.toCharArray())
        {
            freq1[ch-'a']--;
        }
        for(char ch:magazine.toCharArray())
        {
            freq1[ch-'a']++;
        }
        for(int i:freq1)
        {
            if(i<0)
            {
                return false;
            }
        }
        return true;
    }
}
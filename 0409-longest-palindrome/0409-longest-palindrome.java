class Solution {
    public int longestPalindrome(String s) {
        Set<Character> set=new HashSet<>();
        int res=0;
        for(char ch:s.toCharArray())
        {
            if(set.contains(ch))
            {
                res+=2;
                set.remove(ch);
            }
            else{
                set.add(ch);
            }
        }
        return set.isEmpty()? res : res+1;
    }
}
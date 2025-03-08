class Solution {
    public static boolean isSubsequence(String s, String t) {
        if(s.length()>t.length()) return false;
        int idx=-1;
        for(int i=0;i<s.length();i++)
        {
            idx=t.indexOf(s.charAt(i),idx);
            if(idx==-1) return false;
            idx++;
        }
        return true;
    }
    public int numMatchingSubseq(String s, String[] words) {
        int count=0;
        for(int i=0;i<words.length;i++)
        {
            if(isSubsequence(words[i],s)) count++;
        }
        return count;
    }
}
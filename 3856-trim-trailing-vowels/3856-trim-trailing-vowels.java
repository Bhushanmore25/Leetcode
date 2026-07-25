class Solution {
    public String trimTrailingVowels(String s) {
        int r=s.length()-1;
        while(r>=0)
        {
            if(s.charAt(r)=='a'||s.charAt(r)=='e'||s.charAt(r)=='i'||s.charAt(r)=='o'||s.charAt(r)=='u') r--;
            else break;
        }
        r++;
        if(r==0) return "";
        return s.substring(0,r);
    }
}
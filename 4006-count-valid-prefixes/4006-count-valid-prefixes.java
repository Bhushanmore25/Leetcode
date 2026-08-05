class Solution {
    public int countValidPrefixes(String s) {
        int count=0,one=0,zero=0;
        for(char c:s.toCharArray())
        {
            if(c=='0') zero++;
            else one++;
            if(Math.abs(one-zero)<=1) count++;
        }
        return count;
    }
}
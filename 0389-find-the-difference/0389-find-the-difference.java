class Solution {
    public char findTheDifference(String s, String t) {
        char[] str=s.toCharArray();
        char[] str2=t.toCharArray();
        Arrays.sort(str);
        Arrays.sort(str2);
        for(int i=0;i<str.length;i++)
        {
            if(str[i]!=str2[i]) return str2[i];
        }
        return str2[str2.length-1];
    }
}
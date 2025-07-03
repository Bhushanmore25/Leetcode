class Solution {
    public char kthCharacter(int k) {
        StringBuilder str=new StringBuilder("a");
        while(str.length()<=k)
        {
            StringBuilder s=new StringBuilder();
            for(int i=0;i<str.length();i++)
            {
                char ch=(char)(str.charAt(i)+1);
                s.append(ch);
            }
            str.append(s.toString());
        }
        return str.charAt(k-1);
    }
}
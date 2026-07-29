class Solution {
    public int passwordStrength(String password) {
        int c=0;
        Set<Character> set=new HashSet<>();
        for(char ch:password.toCharArray())
        {
            if(set.contains(ch)) continue;
            if(ch>='a' && ch<='z')
            {
                c+=1;
                set.add(ch);
            }
            if(ch>='A' && ch<='Z')
            {
                c+=2;
                set.add(ch);
            }
            if(ch>='0' && ch<='9')
            {
                c+=3;
                set.add(ch);
            }
            if(ch=='!' || ch=='@' || ch=='#' || ch=='$')
            {
                c+=5;
                set.add(ch);
            }
        }
        return c;
    }
}
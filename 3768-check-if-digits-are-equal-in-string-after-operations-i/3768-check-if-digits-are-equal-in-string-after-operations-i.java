class Solution {
    public boolean hasSameDigits(String s) {
        // int n=s.length();
        StringBuilder str=new StringBuilder(s);
        while(str.length()>2)
        {
            StringBuilder str2=new StringBuilder();
            int n=str.length();
            for(int i=0;i<n-1;i++)
            {
                int x=((str.charAt(i)-'0')+(str.charAt(i+1)-'0'))%10;
                str2.append(x);
            }
            str=str2;
        }
        if(str.charAt(0)==str.charAt(1)) return true;
        return false;
    }
}
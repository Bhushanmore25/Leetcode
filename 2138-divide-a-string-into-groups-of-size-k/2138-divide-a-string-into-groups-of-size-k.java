class Solution {
    public String[] divideString(String s, int k, char fill) {
        int size = (int)Math.ceil((double)s.length() / k);
        String[] ans=new String[size];
        StringBuilder str=new StringBuilder();
        int j=0;
        for(int i=0;i<s.length();i++)
        {
            str.append(s.charAt(i));
            if(str.length()==k)
            {
                ans[j++]=str.toString();
                str=new StringBuilder();
            }
        }
        if (str.length() > 0) { 
            while (str.length() < k) {
                str.append(fill);
            }
            ans[j++] = str.toString();
        }

        return ans;       
    }
}
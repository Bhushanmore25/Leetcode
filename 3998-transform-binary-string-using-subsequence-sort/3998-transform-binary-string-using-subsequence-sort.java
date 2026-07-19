class Solution {
    public static boolean check(String s,StringBuilder t)
    {
        int a=0,b=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='1') a++;
            if(t.charAt(i)=='1') b++;
            if(a<b) return false;
        }
        return true;
    }
    public boolean[] transformStr(String s, String[] strs) {
        int c0=0,c1=0,n=s.length();
        for(char c:s.toCharArray())
        {
            if(c=='0') c0++;
            else c1++;
        }
        boolean[] ans=new boolean[strs.length];
        int z=0;
        for(String x:strs)
        {
            int count0=0,count1=0;
            boolean flag=true;
            for(char c:x.toCharArray())
            {
                if(c=='0') count0++;
                else if(c=='1') count1++;
            }
            if(count0>c0 || count1>c1) flag=false;
            else{
                int req0=c0-count0;
                StringBuilder a=new StringBuilder(x);
                for(int i=0;i<n;i++)
                {
                    if(a.charAt(i)=='?')
                    {
                        if(req0>0) {
                            a.setCharAt(i,'0');
                            req0--;    
                        }
                        else a.setCharAt(i,'1');
                    }
                }
                if(!check(s,a)) flag=false;
            }
            ans[z++]=flag;
        }
        return ans;
    }
}
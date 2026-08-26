class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        List<String> li=new ArrayList<>();
        int l=0,r=0,count=0;
        for(r=0;r<s.length();r++)
        {
            if(s.charAt(r)=='1') count++;
            if(count==k)
            {
                while(s.charAt(l)=='0') l++;
                li.add(s.substring(l,r+1));
                count--;
                l++;
            }
        }
        Collections.sort(li,(a,b)->{
            if(a.length()==b.length())
            {
                return a.compareTo(b);
            }
            return a.length()-b.length();
        });
        return li.size()==0 ? "" : li.get(0);
    }
}
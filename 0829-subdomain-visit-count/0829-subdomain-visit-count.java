class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String,Integer> map=new HashMap<>();
        for(String s:cpdomains)
        {
            String[] sub=s.split(" ");
            int count=Integer.parseInt(sub[0]);
            map.put(sub[1],map.getOrDefault(sub[1],0)+count);
            for(int i=0;i<sub[1].length();i++)
            {
                if(sub[1].charAt(i)=='.')
                {
                    String str=sub[1].substring(i+1);
                    map.put(str,map.getOrDefault(str,0)+count);
                }
            }
        }
        List<String> ans=new ArrayList<>();
        for(String str:map.keySet())
        {
            String temp= map.get(str) +" "+str;
            ans.add(temp);
        }
        return ans;
    }
}
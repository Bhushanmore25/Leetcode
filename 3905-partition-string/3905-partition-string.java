class Solution {
    public List<String> partitionString(String s) {
        List<String> ans=new ArrayList<>();
        Set<String> set=new HashSet<>();
        StringBuilder str=new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            str.append(s.charAt(i));
            if(!set.contains(str.toString()))
            {
                set.add(str.toString());
                ans.add(str.toString());
                str=new StringBuilder();
            }
        }
        return ans;
    }
}
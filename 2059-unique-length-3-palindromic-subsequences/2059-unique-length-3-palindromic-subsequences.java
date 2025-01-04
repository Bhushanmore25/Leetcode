class Solution {
    public int countPalindromicSubsequence(String s) {
        int count=0;
        Map<Character,int[]> map=new HashMap<>();
        for(char ch='a';ch<='z';ch++)
        {
            map.put(ch, new int[]{-1,-1});
        }
        for(int i=0;i<s.length();i++)
        {
            int[] res=map.get(s.charAt(i));
            if(res[0]==-1)
            {
                res[0]=i;
            }
            res[1]=i;
            map.put(s.charAt(i),res);
        }
        for(Map.Entry<Character,int[]> entry : map.entrySet())
        {
            HashSet<Character> set=new HashSet<>();
            int[] res=entry.getValue();
            for(int i=res[0]+1;i<res[1];i++)
            {
                set.add(s.charAt(i));
            }
            count+=set.size();
        }
        return count;

    }
}
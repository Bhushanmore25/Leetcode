class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        HashSet<Character> hs = new HashSet<>();
        hs.add('a');
        hs.add('e');
        hs.add('i');
        hs.add('o');
        hs.add('u');
        int[] ans=new int[queries.length];
        int[] prefix=new int[words.length+1];
        for(int i=0;i<words.length;i++)
        {
            if(hs.contains(words[i].charAt(words[i].length()-1)) && hs.contains(words[i].charAt(0)))
            {
                prefix[i+1]=prefix[i]+1;
            }
            else{
                prefix[i + 1] = prefix[i];
            }
        }
        for(int i=0;i<queries.length;i++)
        {
            int x=queries[i][0];
            int y=queries[i][1];
            ans[i]=prefix[y+1]-prefix[x];
        }
        return ans;
    }
}
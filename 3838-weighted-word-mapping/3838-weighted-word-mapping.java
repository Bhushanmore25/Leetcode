class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder str=new StringBuilder();
        for(String s:words)
        {
            int total=0;
            for(int i=0;i<s.length();i++)
            {
                total+=weights[s.charAt(i)-'a'];
            }
            total%=26;
            // System.out.println(total);
            char ch = (char) ('z' - total);
            str.append(ch);
        }
        return str.toString();
    }
}
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char ans=letters[0];
        int dist= ans-target;
        for(int i=0;i<letters.length;i++)
        {
            int val=letters[i]-target;
            if(val<dist || val>0)
            {
                return letters[i];
            }
        }
        return ans;
    }
}
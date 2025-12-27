class Solution {
    public int bestClosingTime(String s) {
        int totalY=0,totalN=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='Y') totalY++;
            else totalN++;
        }
        int ans=0,penalty=totalY;
        int currY=0,currN=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='Y') currY++;
            else currN++;
            int currPenalty=currN+(totalY-currY);
            if(currPenalty<penalty)
            {
                penalty=currPenalty;
                ans=i+1;
            }
        }
        return ans;
    }
}
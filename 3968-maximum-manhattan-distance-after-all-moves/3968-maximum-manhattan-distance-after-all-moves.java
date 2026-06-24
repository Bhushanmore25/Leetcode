class Solution {
    public int maxDistance(String moves) {
        int x=0,y=0,c=0;
        for(char ch:moves.toCharArray())
        {
            if(ch=='L') x--;
            if(ch=='R') x++;
            if(ch=='U') y++;
            if(ch=='D') y--;
            if(ch=='_') c++;
        }
        return Math.abs(x)+Math.abs(y)+c;
    }
}
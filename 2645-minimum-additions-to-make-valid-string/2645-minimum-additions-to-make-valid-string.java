class Solution {
    public int addMinimum(String s) {
        int cost=0;
        char check='a';
        int end=0;
        while(end<s.length())
        {
            if(s.charAt(end)==check) end++;
            else cost++;

            if(check=='a' || check =='b') check++;
            else if(check=='c') check ='a';
        }
        if(s.charAt(s.length()-1)=='a') cost+=2;
        if(s.charAt(s.length()-1)=='b') cost+=1;
        return cost;
    }
}
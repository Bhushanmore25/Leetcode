class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int total=0,empty=0;
        for(int i=0;i<numBottles;i++)
        {
            total++;
            empty++;
            if(empty==numExchange){
                numBottles++; 
                empty=0;
            }
        }
        return total;
    }
}
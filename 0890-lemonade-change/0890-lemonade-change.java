class Solution {
    public boolean lemonadeChange(int[] bills) {
        int count5=0;
        int count10=0;
        for (int bill : bills) {
            if (bill==5) {
                ++count5;
            }
            else if (bill==10) {
                if (count5>0) {
                    count10++;
                    count5--;
                }
                else{
                    return false;
                }
            }
            else{
                if (count10>0 && count5>0) {
                    count10--;
                    count5--;
                }
                else if(count5>2){
                    count5-=3;
                }
                else{
                    return false;
                }
            }
            if (count5<0) {
                return false;
            }
        }
        return true;
    }
}
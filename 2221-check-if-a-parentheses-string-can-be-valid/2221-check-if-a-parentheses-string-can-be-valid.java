class Solution {
    public boolean canBeValid(String s, String locked) {
        if((s.length() & 1) == 1) return false;
        int count1 = 0, count2 = 0;
        for(int i = 0; i < s.length(); i++) {
            if(locked.charAt(i) == '0') {
                count1--;
                count2++;
            }
            else {
                if(s.charAt(i) == '(') {
                    count1++;
                    count2++;
                }
                else {
                    count2--;
                    count1--;
                }
            }
            if(count2 < 0) return false;
            count1 = Math.max(count1, 0);
        }
        return count1 == 0;
    }
}
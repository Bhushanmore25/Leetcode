class Solution {
    public boolean canBeValid(String s, String locked) {
        if((s.length() & 1) == 1) return false;
        int cmin = 0, cmax = 0;
        for(int i = 0; i < s.length(); i++) {
            if(locked.charAt(i) == '0') {
                cmin--;
                cmax++;
            }
            else {
                if(s.charAt(i) == '(') {
                    cmax++;
                    cmin++;
                }
                else {
                    cmax--;
                    cmin--;
                }
            }
            if(cmax < 0) return false;
            cmin = Math.max(cmin, 0);
        }
        return cmin == 0;
    }
}
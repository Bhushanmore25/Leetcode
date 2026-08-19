class Solution {
    public boolean validDigit(int n, int x) {
        String s=Integer.toString(n);
        String t=Integer.toString(x);
        if(s.charAt(0)==t.charAt(0)) return false;
        if(!s.contains(t)) return false;
        return true;
    }
}
class Solution {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        return getColor(coordinate1) == getColor(coordinate2);
    }

    private boolean getColor(String coordinate) {
        int col = coordinate.charAt(0) - 'a';
        int row = coordinate.charAt(1) - '1';
        return (col + row) % 2 == 1; 
    }
}

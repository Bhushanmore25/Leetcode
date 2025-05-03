class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int candidate1 = tops[0];
        int candidate2 = bottoms[0];

        int count1 = getMinRotations(candidate1, tops, bottoms);
        int count2 = (candidate1 == candidate2) ? Integer.MAX_VALUE : getMinRotations(candidate2, tops, bottoms);

        return (count1 == Integer.MAX_VALUE && count2 == Integer.MAX_VALUE) ? -1 : Math.min(count1, count2);
    }

    private int getMinRotations(int target, int[] tops, int[] bottoms) {
        int countTop = 0;
        int countBottom = 0;

        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != target && bottoms[i] != target) {
                return Integer.MAX_VALUE; 
            } else if (tops[i] != target) {
                countTop++;
            } else if (bottoms[i] != target) {
                countBottom++; 
            }
        }

        return Math.min(countTop, countBottom);
    }
}

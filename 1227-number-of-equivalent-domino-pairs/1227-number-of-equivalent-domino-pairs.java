class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;

        for (int[] i : dominoes) {
            Arrays.sort(i); 
            int key = i[0] * 10 + i[1];

            int currentCount = map.getOrDefault(key, 0);
            result += currentCount;  
            map.put(key, currentCount + 1);
        }

        return result;
    }
}

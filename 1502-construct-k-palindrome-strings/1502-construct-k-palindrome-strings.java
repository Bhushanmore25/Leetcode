class Solution {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k) {
            return false;
        }
        if (s.length() == k) 
        {
            return true;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (char chr : s.toCharArray()) {
            map.put(chr, map.getOrDefault(chr, 0) + 1);
        }

        int oddCount = 0;
        for (int count : map.values()) {
            if (count % 2 == 1) {
                oddCount++;
            }
        }

        return oddCount <= k;
    }
}
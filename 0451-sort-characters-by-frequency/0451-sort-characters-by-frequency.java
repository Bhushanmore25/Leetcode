import java.util.*;

class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        TreeMap<Integer, List<Character>> freqMap = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            char ch = entry.getKey();
            freqMap.computeIfAbsent(freq, k -> new ArrayList<>()).add(ch);
        }
        StringBuilder ans = new StringBuilder();
        for (Map.Entry<Integer, List<Character>> entry : freqMap.entrySet()) {
            int freq = entry.getKey();
            for (char ch : entry.getValue()) {
                for (int i = 0; i < freq; i++) {
                    ans.append(ch);
                }
            }
        }

        return ans.toString();
    }
}

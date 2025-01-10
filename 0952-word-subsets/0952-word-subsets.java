class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] maxFreqWords2 = new int[26];
        for (String word : words2) {
            int[] freq = getFrequency(word);
            for (int i = 0; i < 26; i++) {
                maxFreqWords2[i] = Math.max(maxFreqWords2[i], freq[i]);
            }
        }

        List<String> result = new ArrayList<>();
        for (String word : words1) {
            int[] freq = getFrequency(word);
            if (isUniversal(freq, maxFreqWords2)) {
                result.add(word);
            }
        }
        return result;
    }

    private int[] getFrequency(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }

    private boolean isUniversal(int[] freq, int[] maxFreqWords2) {
        for (int i = 0; i < 26; i++) {
            if (freq[i] < maxFreqWords2[i]) {
                return false;
            }
        }
        return true;
    }
}
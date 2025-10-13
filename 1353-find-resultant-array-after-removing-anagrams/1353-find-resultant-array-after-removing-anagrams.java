class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        String prevKey = "";
        
        for (String word : words) {
            char[] ch = word.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            if (!key.equals(prevKey)) {
                ans.add(word);
                prevKey = key;
            }
        }
        return ans;
    }
}
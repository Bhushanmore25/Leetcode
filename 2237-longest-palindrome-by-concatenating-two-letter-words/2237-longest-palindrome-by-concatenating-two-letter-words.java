class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
            String rev = new StringBuilder(s).reverse().toString();
            if (!set.contains(s) && !set.contains(rev)) set.add(s);
        }

        Iterator<String> i = set.iterator();
        int count = 0;
        boolean hasOddPalindrome = false;

        while (i.hasNext()) {
            String s = i.next();
            String rev = new StringBuilder(s).reverse().toString();
            if (s.equals(rev)) {
                int freq = map.get(s);
                count += 4 * (freq / 2);
                if (freq % 2 == 1) hasOddPalindrome = true;
            } else if (map.containsKey(rev)) {
                int min = Math.min(map.get(s), map.get(rev));
                count += 4 * min;
            }
        }

        if (hasOddPalindrome) count += 2;
        return count;
    }
}

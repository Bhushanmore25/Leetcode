class Solution {
    char[] parent = new char[26];

    public void make(char c) {
        parent[c - 'a'] = c;
    }

    public char find(char c) {
        if (parent[c - 'a'] == c) return c;
        parent[c - 'a'] = find(parent[c - 'a']);
        return parent[c - 'a'];
    }

    public void union(char a, char b) {
        char rootA = find(a);
        char rootB = find(b);
        if (rootA == rootB) return;

        if (rootA < rootB) {
            parent[rootB - 'a'] = rootA;
        } else {
            parent[rootA - 'a'] = rootB;
        }
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        for (char c = 'a'; c <= 'z'; c++) {
            make(c);
        }

        for (int i = 0; i < s1.length(); i++) {
            union(s1.charAt(i), s2.charAt(i));
        }

        StringBuilder result = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            result.append(find(c));
        }

        return result.toString();
    }
}

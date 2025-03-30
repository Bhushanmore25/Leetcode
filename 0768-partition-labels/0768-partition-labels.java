class Solution {
  public List<Integer> partitionLabels(String s) {
    

    int[] lastSeen = new int[26];
    for(int i = 0; i < s.length(); i++) {
      lastSeen[s.charAt(i) - 'a'] = i;
    }

    int left = 0, right = 0, prev = 0;
    List<Integer> result = new LinkedList<>();
    while(left < s.length()) {
      right = lastSeen[s.charAt(left) - 'a'];
      while(left <= right) {
        right = Math.max(right, lastSeen[s.charAt(left) - 'a']);
        left++;
      }
      result.add(right+1-prev);
      prev = right+1;
    }
    return result;
  }
}
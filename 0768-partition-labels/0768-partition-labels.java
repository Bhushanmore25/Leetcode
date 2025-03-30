class Solution {
  public List<Integer> partitionLabels(String s) {
    char[] str = s.toCharArray();

    int[] lastSeen = new int[26];
    for(int i = 0; i < str.length; i++) {
      lastSeen[str[i] - 'a'] = i;
    }

    int left = 0, right = 0, prev = 0;
    List<Integer> result = new LinkedList<>();
    while(left < str.length) {
      right = lastSeen[str[left] - 'a'];
      while(left <= right) {
        right = Math.max(right, lastSeen[str[left] - 'a']);
        left++;
      }
      result.add(right+1-prev);
      prev = right+1;
    }
    return result;
  }
}
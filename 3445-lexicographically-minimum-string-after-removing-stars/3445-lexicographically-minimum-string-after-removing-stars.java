class Solution {
    public String clearStars(String s) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);  // Ascending on first column
            } else {
                return Integer.compare(b[1], a[1]);  // Descending on second column
            }
        });
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='*')
            {
                int[] temp=pq.poll();
                set.add(temp[1]);
                continue;
            }
            pq.offer(new int[]{s.charAt(i)-'a',i});
        }
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            if(!set.contains(i) && s.charAt(i)!='*') ans.append(s.charAt(i));
        }
        return ans.toString();
    }
}
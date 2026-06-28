class Solution {
    public List<List<Integer>> filterOccupiedIntervals(int[][] o, int freeStart, int freeEnd) {
        Arrays.sort(o, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> newO = new ArrayList<>();
        
        for (int i = 0; i < o.length; i++) {
            int os = o[i][0];
            int oe = o[i][1];
            
            if (os >= freeStart && oe <= freeEnd) {
                continue;
            }
            else if (os >= freeStart && os <= freeEnd && oe > freeEnd) {
                newO.add(new int[]{freeEnd + 1, oe});
            }
            else if (os < freeStart && oe >= freeStart && oe <= freeEnd) {
                newO.add(new int[]{os, freeStart - 1});
            }
            else if (os < freeStart && oe > freeEnd) {
                newO.add(new int[]{os, freeStart - 1});
                newO.add(new int[]{freeEnd + 1, oe});
            }
            else {
                newO.add(new int[]{os, oe});
            }
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        if (newO.isEmpty()) {
            return ans;
        }
        Collections.sort(newO, (a, b) -> Integer.compare(a[0], b[0]));
        
        int st = newO.get(0)[0];
        int end = newO.get(0)[1];
        
        for (int i = 1; i < newO.size(); i++) {
            int[] curr = newO.get(i);
            
            if (curr[0] <= end + 1) {
                end = Math.max(end, curr[1]);
            } else {
                ans.add(Arrays.asList(st, end));
                st = curr[0];
                end = curr[1];
            }
        }
        ans.add(Arrays.asList(st, end));
        
        return ans;
    }
}
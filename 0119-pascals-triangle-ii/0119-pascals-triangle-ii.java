class Solution {
     public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i <= rowIndex; ++i) {
            Integer[] temp = new Integer[i + 1];
            Arrays.fill(temp, 1);
            ans.add(new ArrayList<>(Arrays.asList(temp))); 
        }

        for (int i = 2; i <= rowIndex; ++i) { 
            for (int j = 1; j < ans.get(i).size() - 1; ++j) {
                ans.get(i).set(j, ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
            }
        }

        return ans.get(rowIndex);
    }
}
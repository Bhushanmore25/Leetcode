class Solution {
    public int numberOfBeams(String[] bank) {
        List<Integer> devices = new ArrayList<>();
        
        for (String row : bank) {
            int count = 0;
            for (char ch : row.toCharArray()) {
                if (ch == '1') count++;
            }
            if (count > 0) devices.add(count);
        }

        int ans = 0;
        for (int i = 1; i < devices.size(); i++) {
            ans += devices.get(i - 1) * devices.get(i);
        }

        return ans;

    }
}
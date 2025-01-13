class Solution {
    public int minimumLength(String s) {
        Map<Character,Integer> mp=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)+1);
            if(mp.get(s.charAt(i))%3==0)
            {
                mp.put(s.charAt(i),1);
            }
        }
        int count = 0;
        for (int value : mp.values()) {
            count += value;
        }
        return count;
    }
}
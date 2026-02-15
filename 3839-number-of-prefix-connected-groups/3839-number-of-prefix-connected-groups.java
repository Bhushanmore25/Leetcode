class Solution {
    public int prefixConnected(String[] words, int k) {
        Arrays.sort(words);
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i<words.length;i++)
        {
            if(words[i].length()<k) continue;
            map.put(words[i].substring(0,k),map.getOrDefault(words[i].substring(0,k),0)+1);
        }
        int count=0;
        for(String s:map.keySet())
        {
            if(map.get(s)>1) count++;
        }
        return count;
    }
}
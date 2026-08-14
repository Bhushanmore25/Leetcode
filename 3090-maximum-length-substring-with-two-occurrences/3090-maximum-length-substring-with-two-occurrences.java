class Solution {
    public int maximumLengthSubstring(String s) {
        Map<Character,Integer> map=new HashMap<>();
        int len=0,last=0;
        for(int i=0;i<s.length();i++)
        {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            int freq=map.get(s.charAt(i));
            if(freq<=2)
            {
                len=Math.max(len,i-last+1);
            }
            else{
                len=Math.max(len,i-last);
                while(map.get(s.charAt(i))>2)
                {
                    map.put(s.charAt(last),map.get(s.charAt(last))-1);
                    last++;
                }

            }
        }
        return len;
    }
}
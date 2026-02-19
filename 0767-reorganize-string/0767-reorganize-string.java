class Solution {
    public String reorganizeString(String s) {
        int[] freq=new int[26];
        int maxi=0;
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
            maxi=Math.max(maxi,freq[s.charAt(i)-'a']);
        }
        if(maxi > (s.length()+1) / 2) return "";
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(b[1],a[1]));
        for(int i=0;i<26;i++) if(freq[i]>0) pq.offer(new int[]{i,freq[i]});
        StringBuilder ans =new StringBuilder();
        while(pq.size()>1)
        {
            int[] first=pq.poll();
            int[] second=pq.poll();
            ans.append((char)('a'+first[0]));
            ans.append((char)('a'+second[0]));
            first[1]-=1;
            second[1]-=1;
            if(first[1]>0) pq.offer(new int[]{first[0],first[1]}); 
            if(second[1]>0) pq.offer(new int[]{second[0],second[1]}); 
        }
        if(pq.size()==0) return ans.toString();
        int x=pq.poll()[0];
        ans.append((char)('a'+x));
        // System.out.println(x);
        return ans.toString();
    }
}
class Solution {
    public String longestDiverseString(int a, int b, int c) {
    StringBuilder str = new StringBuilder();
    PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[0] - x[0]);
    if(a>0)
    {
        pq.add(new int[]{a,'a'});
    }
    if(b>0)
    {
        pq.add(new int[]{b,'b'});
    }
    if(c>0)
    {
        pq.add(new int[]{c,'c'});
    }
    while(!pq.isEmpty())
    {
        int[] curr=pq.poll();
        int freq=curr[0];
        char ch=(char)curr[1];
        int n=str.length();
        if(n>=2 && str.charAt(n-1)==ch && str.charAt(n-2)==ch)
        {
            if(pq.isEmpty())
            {
                break;
            }
            int[] next=pq.poll();
            int freq2=next[0];
            char ch2=(char)next[1];
            str.append(ch2);
            freq2--;
            if(freq2>0)
            {
                pq.add(new int[]{freq2,ch2});
            }
            pq.add(new int[]{freq,ch});
        }
        else{
            str.append(ch);
            freq--;
            if(freq>0)
            {
                pq.add(new int[]{freq,ch});
            }
        }

    }
    return str.toString();
}
}
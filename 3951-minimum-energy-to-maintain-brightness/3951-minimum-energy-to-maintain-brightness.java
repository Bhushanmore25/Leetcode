class Solution {
    public long minEnergy(int n, int brightness, int[][] inv) {
        Arrays.sort(inv,(a,b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        int st=inv[0][0];
        int end=inv[0][1];
        List<int[]> li=new ArrayList<>();
        for(int[] i:inv)
        {
            if(i[0]<=end) end=Math.max(end,i[1]);
            else{
                li.add(new int[]{st,end});
                st=i[0];
                end=i[1];
            }
        }
        li.add(new int[]{st,end});
        long count=(brightness+2)/3;
        long ans=0l;
        for(int[] i:li)
        {
            long term=i[1]-i[0]+1;
            ans+=term*count;
        }
        return ans;
    }
}
class Solution {
    public int numberOfBeams(String[] bank) {
        List<Integer> li=new ArrayList<>();
        for(int i = bank.length-1; i >= 0 ;i-- )
        {
            int c=0;
            for(char ch:bank[i].toCharArray()) if(ch=='1') c++;
            li.add(c);
        }
        int ans=0,n = li.size();
        for(int i=0;i<n;)
        {
            if (li.get(i) == 0) { 
                i++;
                continue;
            }
            int j=i+1;
            while(j<n && li.get(j)==0) j++;
            if(j==n) break;
            int x=li.get(i)*li.get(j);
            System.out.println(x);
            ans+=x;
            i=j;
        }
        return ans;
    }
}
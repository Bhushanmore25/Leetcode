class Solution {
    public int[] decimalRepresentation(int n) {
        List<Integer> li=new ArrayList<>();
        int count=0;
        while(n!=0)
        {
            int temp=(int)Math.pow(10,count++)*(n%10);
            if(temp!=0) 
                li.add(temp);
            n/=10;
        }
        Collections.sort(li,Collections.reverseOrder());
        int[] ans=new int[li.size()];
        for(int i=0;i<li.size();i++) ans[i]=li.get(i);
        return ans;
    }
}
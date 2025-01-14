class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n=A.length;
        // int[] prefix=new int[n];
        Map<Integer,Integer> mpa=new HashMap<>();
        Map<Integer,Integer> mpb=new HashMap<>();
        int[] ans=new int[n];
        for(int i=0;i<n;i++)
        {
            mpa.put(A[i],mpa.getOrDefault(A[i],0)+1);
            mpb.put(B[i],mpb.getOrDefault(B[i],0)+1);
            int count=0;
            for (Map.Entry<Integer, Integer> set : mpa.entrySet()) {
                if(mpb.containsKey(set.getKey()))
                {
                    count++;
                }
            }
            ans[i]=count;
        }
        return ans;
    }
}
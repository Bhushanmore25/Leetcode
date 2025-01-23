class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            } else {
                return a[0] - b[0];
            }
        });
        int[] dp=new int[envelopes.length];
        int maxlen=0;
        for(int i=0;i<dp.length;i++)
        {
            int idx=binarysearch(dp , 0 , maxlen , envelopes[i][1]);
            dp[idx]=envelopes[i][1];
            if(idx==maxlen)
            {
                maxlen++;
            }
        }
        return maxlen;
    }
    public static int binarysearch(int[] arr, int start, int end ,int target)
    {
         while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
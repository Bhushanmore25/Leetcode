class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long n1Zeros = 0, n2Zeros = 0;
        long n1Sum = 0, n2Sum = 0;

        for (int num : nums1) {
            if (num == 0) n1Zeros++;
            n1Sum += num;
        }

        for (int num : nums2) {
            if (num == 0) n2Zeros++;
            n2Sum += num;
        }

        if (n1Zeros == 0 && n1Sum < (n2Sum + n2Zeros)) {
            return -1;
        }

        if (n2Zeros == 0 && n2Sum < (n1Sum + n1Zeros)) {
            return -1;
        }

        return Math.max(n1Sum + n1Zeros, n2Sum + n2Zeros);
    }
}

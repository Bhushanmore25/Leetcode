import java.util.*;
class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, (a, b) -> {
            if (a.length() != b.length())
                return a.length() - b.length(); // shorter first
            return a.compareTo(b); // lexicographically
        });
        return nums[nums.length - k];
    }
}
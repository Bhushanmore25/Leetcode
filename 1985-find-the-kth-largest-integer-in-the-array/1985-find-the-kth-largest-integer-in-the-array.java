import java.util.*;
class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, (a, b) -> {
            if (a.length() != b.length())
                return a.length() - b.length(); 
            return a.compareTo(b); 
        });
        return nums[nums.length - k];
    }
}
// import java.math.BigInteger;
// import java.util.PriorityQueue;

// class Solution {
//     public String kthLargestNumber(String[] nums, int k) {
//         var pq = new PriorityQueue<BigInteger>();

//         for (String s : nums) {
//             pq.add(new BigInteger(s)); 
//             if (pq.size() > k) {
//                 pq.poll();
//             }
//         }

//         return pq.peek().toString();
//     }
// }
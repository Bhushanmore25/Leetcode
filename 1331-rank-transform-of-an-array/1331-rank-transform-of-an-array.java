class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] nums=Arrays.copyOf(arr,arr.length);
        Arrays.sort(nums);
        Map<Integer,Integer> map=new HashMap<>();
        int count=1;
        for(int i=0;i<nums.length;i++)
            if(!map.containsKey(nums[i])) map.put(nums[i],count++);
        for(int i=0;i<arr.length;i++)
            arr[i]=map.get(arr[i]);
        return arr;
    }
}
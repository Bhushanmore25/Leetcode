class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Arrays.sort(arr);
        Set<Integer> set=new HashSet<>();
        int occur=1,num=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]==num)
            {
                occur++;
            }
            else{
                if(set.contains(occur)) return false;
                set.add(occur);
                num=arr[i];
                occur=1;
            }
        }
        if(set.contains(occur)) return false;

        return true;
    }
}
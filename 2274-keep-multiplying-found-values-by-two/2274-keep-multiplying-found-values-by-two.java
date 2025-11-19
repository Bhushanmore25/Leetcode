class Solution {
    public int findFinalValue(int[] nums, int original) {
            while(true) {
                if(hasNum(nums, original))
                    original *= 2;
                else
                    return original;
            }
        }

        private boolean  hasNum(int[] arr, int original) {
            for(int x:arr)
                if(x == original) 
                    return true;
            return false;
        }
}
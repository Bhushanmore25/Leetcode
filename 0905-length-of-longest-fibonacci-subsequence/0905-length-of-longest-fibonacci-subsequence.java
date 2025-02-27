class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++)
        {
            map.put(arr[i],i);
        }
        int maxlen=0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int a = arr[i], b = arr[j];
                int length = 2; 
                
                while (map.containsKey(a + b)) {
                    int next = a + b;
                    a = b;
                    b = next;
                    length++;
                }
                
                maxlen = Math.max(maxlen, length);
            }
        }
        
        return maxlen >= 3 ? maxlen : 0;
    }
}
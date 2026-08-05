class Solution {
    public int maximumWidth(int[] planks) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> li = new ArrayList<>();
        int maxFreq = 0;
        for(int i : planks) {
            if(!map.containsKey(i)) li.add(i);
            map.put(i, map.getOrDefault(i, 0) + 1);
            if(map.get(i) > maxFreq) {
                maxFreq = map.get(i);
            }
        }
        Map<Integer, Integer> sumMap = new HashMap<>();
        for(int i : li) {
            sumMap.put(i, map.get(i));
        }
    
        for(int i = 0; i < li.size(); i++) {
            
            int count = map.get(li.get(i));
            if(count >= 2) {
                int add = li.get(i) + li.get(i);
                int pairs = count / 2; 
                sumMap.put(add, sumMap.getOrDefault(add, 0) + pairs);
                
                if(sumMap.get(add) > maxFreq) maxFreq = sumMap.get(add);
            }
            
            for(int j = i + 1; j < li.size(); j++) {
                int add = li.get(i) + li.get(j);
                
                int pairs = Math.min(map.get(li.get(i)), map.get(li.get(j)));
                sumMap.put(add, sumMap.getOrDefault(add, 0) + pairs);
                if(sumMap.get(add) > maxFreq) {
                    maxFreq = sumMap.get(add);
                }
            }
        }
        
        return maxFreq; 
    }
}
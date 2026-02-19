class LRUCache {
    int count;
    int capacity;
    TreeMap<Integer, List<Integer>> kv;
    TreeMap<Integer, Integer> countk;
    public LRUCache(int capacity) {
        count=0;
        kv=new TreeMap<>();
        countk=new TreeMap<>();
        this.capacity=capacity;
    }
    
    public int get(int key) {
        if(kv.containsKey(key))
        {
            List<Integer> li=kv.get(key);
            countk.remove(li.get(0));
            countk.put(count,key);
            int val=li.get(1);
            li.set(0,count++);
            kv.put(key,li);
            return val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        int x=get(key);
        if(x!=-1)
        {
            List<Integer> li=kv.get(key);
            countk.remove(li.get(0));
            countk.put(count,key);
            li.set(0,count++);
            li.set(1,value);
            kv.put(key,li);
            return;
        }
        if(countk.size()>=capacity)
        {
            int k=countk.firstKey();
            int oldKey=countk.get(k);
            countk.remove(k);
            kv.remove(oldKey);
        }
        List<Integer> li=new ArrayList<>();
        countk.put(count,key);
        li.add(count++);
        li.add(value);
        kv.put(key,li);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> query=new HashMap<>();
        Map<Integer, Integer> colors=new HashMap<>();
        int n=queries.length;
        int[] res=new int[n];

        for(int i=0; i<n; i++){
            if(!query.containsKey(queries[i][0])){
                query.put(queries[i][0],queries[i][1]);
            }else{
                if(colors.get(query.get(queries[i][0]))==1){
                    colors.remove(query.get(queries[i][0]));
                }else{
                    colors.put(query.get(queries[i][0]), colors.get(query.get(queries[i][0]))-1);
                }
                query.put(queries[i][0],queries[i][1]);
            }

            colors.put(queries[i][1],colors.getOrDefault(queries[i][1],0)+1);

            res[i]=colors.size();
        }
        
        return res;
    }
}
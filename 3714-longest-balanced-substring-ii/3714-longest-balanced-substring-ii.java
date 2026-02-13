class Solution {
    public int longestBalanced(String s) {

        int n = s.length();
        int ans=1,count=1;
        for(int i=1;i<n;i++)
        {
            if(s.charAt(i)!=s.charAt(i-1)) count=0;
            count++;
            ans=Math.max(count,ans);
        }

        int a=0,b=0,c=0;
        Map<List<Integer>,Integer> ab=new HashMap<>();
        Map<List<Integer>,Integer> bc=new HashMap<>();
        Map<List<Integer>,Integer> ac=new HashMap<>();
        Map<List<Integer>,Integer> abc=new HashMap<>();

        ab.put(Arrays.asList(0,0),0);
        bc.put(Arrays.asList(0,0),0);
        ac.put(Arrays.asList(0,0),0);
        abc.put(Arrays.asList(0,0),0);
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)=='a') a++;
            else if(s.charAt(i)=='b') b++;
            else c++;

            if(ab.containsKey(Arrays.asList(a-b,c))) ans=Math.max(ans,i-ab.get(Arrays.asList(a-b,c))+1);
            else ab.put(Arrays.asList(a-b,c),i+1);
            if(bc.containsKey(Arrays.asList(b-c,a))) ans=Math.max(ans,i-bc.get(Arrays.asList(b-c,a))+1);
            else bc.put(Arrays.asList(b-c,a),i+1);
            if(ac.containsKey(Arrays.asList(a-c,b))) ans=Math.max(ans,i-ac.get(Arrays.asList(a-c,b))+1);
            else ac.put(Arrays.asList(a-c,b),i+1);
            if(abc.containsKey(Arrays.asList(a-b,b-c))) ans=Math.max(ans,i-abc.get(Arrays.asList(a-b,b-c))+1);
            else abc.put(Arrays.asList(a-b,b-c),i+1);
            
        }

        return ans;
    }
}

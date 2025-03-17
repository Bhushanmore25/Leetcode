class Solution {
    public static void permutation(List<List<Integer>> li,List<Integer> ans,List<Integer> num)
    {
        if(num.size()==0)
        {
            li.add(new ArrayList<>(ans));
            return;
        }

        for(int i=0;i<num.size();i++)
        {
            int element = num.get(i); 
            ans.add(element);
            num.remove(i); 
            permutation(li, ans, num);
            ans.remove(ans.size() - 1);
            num.add(i, element);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> li=new ArrayList<>();
        List<Integer> num=new ArrayList<>();
        List<Integer> lis=new ArrayList<>();
        for(int i:nums)
        {
            num.add(i);
        }

        permutation(li,lis,num);

        Collections.sort(li, (a, b) -> {
            int n = Math.min(a.size(), b.size());
            for (int i = 0; i < n; i++) {
                if (!a.get(i).equals(b.get(i))) {
                    return Integer.compare(a.get(i), b.get(i)); 
                }
            }
            return Integer.compare(a.size(), b.size()); 
        });
        List<List<Integer>> uniqueLi = new ArrayList<>();
        Set<String> seen = new HashSet<>();
        for (List<Integer> perm : li) {
            String key = perm.toString(); 
            if (!seen.contains(key)) {
                seen.add(key);
                uniqueLi.add(perm);
            }
        }

        return uniqueLi;
    }
}
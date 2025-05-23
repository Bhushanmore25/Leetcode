class Solution {
    public static String[] nums={".","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static void permute(String digits,String temp,int idx, List<String> ans)
    {
        if(idx==digits.length())
        {
            ans.add(temp);
            return;
        }
        String str=nums[(digits.charAt(idx)-'0')- 1];
        for(int i=0;i<str.length();i++)
        {
            permute(digits,temp+str.charAt(i),idx+1,ans);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList<>();
        if(digits.length()==0) return ans;
        permute(digits,"",0,ans);
        return ans;
    }
}
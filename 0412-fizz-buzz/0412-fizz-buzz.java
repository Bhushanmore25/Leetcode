class Solution {
    public List<String> fizzBuzz(int n) {
        String[] str = {"Fizz", "Buzz", "FizzBuzz"};
        List<String> ans=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if((i+1)%3==0 && (i+1)%5==0) ans.add(str[2]);
            else if((i+1)%3==0) ans.add(str[0]);
            else if((i+1)%5==0) ans.add(str[1]);
            else ans.add(String.valueOf(i+1));
        }
        return ans;
    }
}
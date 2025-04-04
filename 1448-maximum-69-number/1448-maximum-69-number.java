class Solution {
    public int maximum69Number (int num) {
        int temp=num;
        List<Integer> li=new ArrayList<>();
        while(temp!=0)
        {
            li.add(temp%10);
            temp/=10;
        }
        int count=0;
        for(int i=li.size()-1;i>=0;i--)
        {
            if(li.get(i)==6)
            {
                li.set(i,9);
                break;
            }
        }
        num=0;
        for(int i=li.size()-1;i>=0;i--)
        {
            num=num*10+li.get(i);
        }
        return num;
    }
}
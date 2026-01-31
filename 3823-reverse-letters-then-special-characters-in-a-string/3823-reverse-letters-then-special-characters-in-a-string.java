class Solution {
    public String reverseByType(String s) {
        List<Character> spec=new ArrayList<>();
        List<Character> ch=new ArrayList<>();
        for(char c:s.toCharArray())
        {
            int dist=c-'a';
            if(dist>=0 && dist<=26) ch.add(c);
            else spec.add(c);
        }
        int l=spec.size()-1,r=ch.size()-1;
        StringBuilder str=new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)>='a' && s.charAt(i)<='z') str.append(ch.get(r--));
            else str.append(spec.get(l--));
        }
        return str.toString();
    }
}
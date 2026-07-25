class Solution {
    public String mergeCharacters(String s, int k) {
        StringBuilder stb=new StringBuilder();
        int freq[]=new int[26];
        Arrays.fill(freq,-1);
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            int curr=ch-'a';
            if(freq[curr]!=-1&&stb.length()-freq[curr]<=k){
                continue;
            }
            freq[curr]=stb.length();
            stb.append(ch);
        }
        return stb.toString();
    }
}
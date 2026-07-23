class Solution {
    public String sortVowels(String s) {
        int[][] freq=new int[26][3];
        int k=0;
        for(int[]i:freq) {
            i[1]=-1;
            i[2]=k++;    
        }
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='a' ||s.charAt(i)=='e' ||s.charAt(i)=='i' ||s.charAt(i)=='o' ||s.charAt(i)=='u' )
            {
                int idx=s.charAt(i)-'a';
                if(freq[idx][1]==-1) freq[idx][1]=i;
                freq[idx][0]+=1;
            }
        }
        Arrays.sort(freq,(a,b) -> {
            if(a[0]==b[0]) return a[1]-b[1];
            return b[0]-a[0];
        });
        StringBuilder ans=new StringBuilder();
        k=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='a' ||s.charAt(i)=='e' ||s.charAt(i)=='i' ||s.charAt(i)=='o' ||s.charAt(i)=='u' ){
                freq[k][0]--;
                ans.append((char)('a'+freq[k][2]));
                if(freq[k][0]==0) k++;
            }
            else{
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }
}
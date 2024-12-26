class Solution {
    public String reverseVowels(String s) {
        StringBuilder str=new StringBuilder(s);
        int i=0,j=s.length()-1;
        HashSet<Character> hs = new HashSet<>();
        hs.add('a');
        hs.add('A');
        hs.add('e');
        hs.add('E');
        hs.add('i');
        hs.add('I');
        hs.add('o');
        hs.add('O');
        hs.add('u');
        hs.add('U');
        while (i < j) {
            while (i < j && !hs.contains(str.charAt(i))) {
                i++;
            }
            while (i < j && !hs.contains(str.charAt(j))) {
                j--;
            }

            char temp = str.charAt(i);
            str.setCharAt(i, str.charAt(j));
            str.setCharAt(j, temp);

            i++;
            j--;
        }
        return str.toString();
    }
}
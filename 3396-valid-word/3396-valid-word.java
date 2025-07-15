class Solution {
    public boolean isValid(String word) {
        if(word.length()<3) return false;
        boolean isValid=true,isVowel=false,isConsonant=false;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!Character.isLetterOrDigit(c)) return false;

            if (Character.isLetter(c)) {
                char lowerC = Character.toLowerCase(c);
                if (lowerC == 'a' || lowerC == 'e' || lowerC == 'i' || lowerC == 'o' || lowerC == 'u') {
                    isVowel = true;
                } else {
                    isConsonant = true;
                }
            }
        }
        return isVowel && isConsonant;
    }
}
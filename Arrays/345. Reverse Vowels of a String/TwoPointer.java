class TwoPointer {
    public String reverseVowels(String s) {
        
        int i = 0;
        int j = s.length() - 1;
        char[] chars = s.toCharArray();
        while (i < j) {
            // move i to vowel
            while (i < s.length() && !isVowel(chars[i])) {
                i++;
            }

            // move j to vowel
            while (j >= 0 && !isVowel(chars[j])) {
                j--;
            }

            if (i < j) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            }
        }
        return new String(chars);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'i' || c == 'e' || c == 'o' || c == 'u'
            || c == 'A' || c == 'I' || c == 'E' || c == 'O' || c == 'U';
    }
}

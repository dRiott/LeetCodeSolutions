/**
 * Learned:
 *   - Counting sort algorithm avoids the actual sorting of the previous implementation altogether:
 *   - "The important point to observe here is that the string temp will only have ten different characters, 
        as there are five vowels and their corresponding upper-case letters. In such scenarios, 
        where the length is much greater than the number of distinct characters, 
        it's much more efficient to use counting sort. 
        This is because we will just have to count the frequencies for just ten characters 
        instead of sorting all the characters in the string temp."
 */
class CountingSort {
    public String sortVowels(String s) {
        
        // counting sort: keep track of the vowel counts in ascii table
        // move to the next non-0 vowel count, append, subtract 1

        int[] ascii = new int[128];
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                ascii[(int) c]++;
            }
        }

        StringBuilder t = new StringBuilder(s.length());
        int currVowel = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (isVowel(s.charAt(i))) {
                
                // skip to the next vowel
                while(ascii[currVowel] == 0) {
                    currVowel++;
                }
                t.append((char) currVowel);
                ascii[currVowel]--;
            } else {
                t.append(s.charAt(i));
            }
        }
        return t.toString();
    }

    private boolean isVowel(char c) {
        switch(c) {
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }
}


class IterateThroughTwice {
    public String reverseVowels(String s) {
        
        StringBuilder vs = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (isVowel(c)) {
                vs.append(c);
            }
        }

        char[] vowels = vs.toString().toCharArray();

        int k = vowels.length - 1;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (isVowel(c)) {
                res.append(vowels[k--]);
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }

    private boolean isVowel(Character c) {
        switch (Character.toLowerCase(c)) {
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

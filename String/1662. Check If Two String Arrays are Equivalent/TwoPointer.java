class TwoPointer {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int w1 = 0, w2 = 0; // word pointer
        int l1 = 0, l2 = 0; // letter pointer

        while (w1 < word1.length && w2 < word2.length) {
            if (word1[w1].charAt(l1) != word2[w2].charAt(l2)) {
                return false;
            }

            // increment pointers
            if (l1+1 < word1[w1].length()) {
                l1++;
            } else {
                w1++;
                l1 = 0;
            }
            if (l2+1 < word2[w2].length()) {
                l2++;
            } else {
                w2++;
                l2 = 0;
            }
        }

        return w1 == word1.length && w2 == word2.length;
    }
}

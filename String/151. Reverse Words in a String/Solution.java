class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        
        int q = 0, j = words.length - 1;
        while (q < j) {
            String temp = words[q];
            words[q++] = words[j];
            words[j--] = temp;
        }

        StringBuilder b = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (words[i] != "") {
                b.append(words[i] + " ");
            }
        }
        int len = b.length();
        return b.toString().substring(0, len-1);
    }
}

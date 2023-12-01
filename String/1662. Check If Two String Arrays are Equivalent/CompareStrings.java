class CompareStrings {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb = new StringBuilder();
        for (String w : word1) {
            sb.append(w);
        }
        String string1 = sb.toString();
        sb.setLength(0);
        for (String w : word2) {
            sb.append(w);
        }
        String string2 = sb.toString();
        return string1.equals(string2);
    }
}

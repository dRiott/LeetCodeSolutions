class FrequencyMap {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        
        Map<Character, Integer> dict = new HashMap<>();
        for (char c : s.toCharArray()) {
            dict.compute(c, (k, v) -> v == null ? 1 : ++v);
        }
        
        for (char c : t.toCharArray()) {
            Integer count = dict.get(c);
            if (count == null) return false;
            if (count == 1) {
                dict.remove(c);
            } else {
                dict.put(c, --count);
            }
        }
        
        return dict.isEmpty();
    }
}

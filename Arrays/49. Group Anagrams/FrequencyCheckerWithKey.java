class FrequencyCheckerWithKey {

    private int[][] freqs;
    private Map<String, List<String>> ans = new HashMap<>();

    public List<List<String>> groupAnagrams(String[] strs) {

        freqs = new int[strs.length][26];
        for (int i = 0; i < strs.length; i++) {
            addFreqMap(i, strs[i]);
        }

        // each string...
        for (int i = 0; i < freqs.length; i++) {
            String key = stringify(freqs[i]);
            
            List<String> group = ans.getOrDefault(key, new ArrayList<>());
            group.add(strs[i]);
            ans.put(key, group);
        }

        return new ArrayList<>(ans.values());
    }

    public void addFreqMap(int curr, String s) {
        int[] sFreq = new int[26];

        for (char c : s.toCharArray()) {
            sFreq[c-'a']+=1;
        }
        freqs[curr] = sFreq;
    }

    public String stringify(int[] freq) {
      StringBuilder sb = new StringBuilder();
      for(int i : freq) {
        sb.append("#" + i);
      }
      return sb.toString();
    }
}

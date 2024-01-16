class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> results = new HashMap<>();

        for (int i = 0; i < matches.length; i++) {
            int winner = matches[i][0];
            int loser = matches[i][1];
            int w = results.getOrDefault(winner, 0);
            results.put(winner, w);
            int l = results.getOrDefault(loser, 0);
            results.put(loser, l+1);
        }

        List<Integer> noLosses = new ArrayList<>();
        List<Integer> oneLosses = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : results.entrySet()) {
            if (e.getValue() == 0) noLosses.add(e.getKey());
            if (e.getValue() == 1) oneLosses.add(e.getKey());
        }

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(noLosses);
        ans.add(oneLosses);
        Collections.sort(ans.get(0));
        Collections.sort(ans.get(1));
        return ans;
    }
}

class SetRemovingSeen {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> seen = new HashSet<>();
        for (int i : nums1) seen.add(i);

        List<Integer> res = new ArrayList<>();
        for (int i : nums2) {
            if (seen.contains(i)) {
                res.add(i);
                seen.remove(i); // only use once
            }
        }

        int[] ans = new int[res.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}

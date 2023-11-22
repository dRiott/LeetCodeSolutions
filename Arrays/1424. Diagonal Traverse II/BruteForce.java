class BruteForce {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        // 0, 0
        // 1, 0 ... 0, 1
        // 2, 0; 1, 1, 0, 2
        // 3, 0; 2, 1; 1, 2; 0, 3

        int i = 0;
        int size = nums.size();
        int len = 0;
        int longestRow = 0;
        for (List<Integer> l : nums) {
            len += l.size();
            longestRow = Math.max(longestRow, l.size());
        }
        int[] res = new int[len];

        int pointer = 0;
        int capIterations = size + longestRow - 1;
        
        while (i < capIterations) {
            int k = i, l = 0;
            if (i >= size) {
                k = size - 1; // max
                l = i - size + 1;
            }
            while (k >= 0 && l <= i) {
                // if inbounds, add
                if (l < nums.get(k).size()) {
                    res[pointer++] = nums.get(k).get(l);
                }
                k--; 
                l++;
            }
            i++;
        }


        return res;
    }
}

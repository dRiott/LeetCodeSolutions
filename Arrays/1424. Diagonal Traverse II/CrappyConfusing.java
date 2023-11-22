class CrappyConfusing {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int size = nums.size();
        int len = 0;
        int longestRow = 0;
        for (List<Integer> l : nums) {
            len += l.size();
            longestRow = Math.max(longestRow, l.size());
        }
        
        int[][] pos = new int[size][];
        int maxRowCol = 0;
        for (int i = 0; i < size; i++) {
            List<Integer> list = nums.get(i);
            pos[i] = new int[list.size()];
            for (int j = 0; j < list.size(); j++) {
                pos[i][j] = i+j;
                maxRowCol = Math.max(maxRowCol, pos[i][j]);
            }
        }

        Map<Integer, List<Integer>> val = new HashMap<>();
        for (int i = 0; i < pos.length; i++) {
            int[] p = pos[i];
            
            for (int j = 0; j < p.length; j++) {
                int colRow = pos[i][j];
                List<Integer> vp = val.getOrDefault(colRow, new ArrayList());
                vp.add(nums.get(i).get(j));
                val.put(colRow, vp);
            }
        }
        
        List<Integer> vals = new ArrayList<>();
        for (int i = 0; i <= maxRowCol; i++) {
            List<Integer> v = val.get(i);
            for (int j = v.size() - 1; j >= 0; j--) {
                vals.add(v.get(j));
            }
       }

        int[] res = new int[vals.size()];
        for (int j = 0; j < vals.size(); j++) {
            res[j] = vals.get(j);
        }
 
        return res;
    }
}

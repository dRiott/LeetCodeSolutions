class ArrayMath {
    public List<Integer> getRow(int rowIndex) {
        // if odd row, has even number of items
        // start addition with rowIndex -1
        if (rowIndex == 0) return List.of(1);
        if (rowIndex == 1) return List.of(1,1);

        int totalLen = 0;
        for (int i = rowIndex+1; i > 0; i--) {
            totalLen+=i;
        }

        int[] triangle = new int[totalLen];
        triangle[0] = 1;
        triangle[1] = 1;
        triangle[2] = 1;

        int row = 2;
        int pos = 3;
        while (row <= rowIndex) {

            int len = row+1;

            // write the numbers 1 and 1
            triangle[pos] = 1;
            triangle[pos+len-1] = 1;
            
            // iterate len - 2 times
            for (int i = pos+1; i <= pos+len-2; i++) {
                triangle[i] = triangle[i-len] + triangle[i-len+1];
            }

            pos += len;
            row++;
        }

        // build into list
        List<Integer> res = new ArrayList<>();
        for (int r = pos-row; r < pos; r++) {
            res.add(triangle[r]);
        }

        return res;
    }
}

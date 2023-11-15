class Greedy {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        // fix the max values of the arr... then
        Arrays.sort(arr);

        int maxForPos = 1;
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] >= maxForPos+1) {
                //arr[i] = maxForPos;
                maxForPos++;
            }
        }
        
        return maxForPos;
    }
}

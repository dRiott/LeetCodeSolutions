class FindingFirstAndSecondLargestSmallest {
    public int maxProductDifference(int[] nums) {
        // find largest and second largest
        // find smallest and second smallest
        
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int i : nums) {
            if (i > largest) {
                secondLargest = largest;
                largest = i;
            } else if (i > secondLargest) {
                secondLargest = i;
            }
            if (i < smallest) {
                secondSmallest = smallest;
                smallest = i;
            } else if (i < secondSmallest) {
                secondSmallest = i;
            }
        }

        return (largest*secondLargest) - (smallest*secondSmallest);
    }
}

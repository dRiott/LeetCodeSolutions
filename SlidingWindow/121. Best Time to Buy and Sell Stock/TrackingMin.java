class TrackingMin {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, profit = Integer.MIN_VALUE;
        for (int i : prices) {
            min = Math.min(min, i);
            profit = Math.max(profit, i-min);
        }   
        return profit;
    }
}

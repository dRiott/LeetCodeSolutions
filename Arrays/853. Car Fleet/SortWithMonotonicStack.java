class SortWithMonotonicStack {
    public int carFleet(int target, int[] position, int[] speed) {
        // ticks until destination
        // target - position[i] / speed[i]
        // but cars bump into each other
        if (position.length == 0) return 0;
        
        double[][] ticks = new double[position.length][2];
        for (int i = 0; i < position.length; i++) {
            ticks[i] = new double[]{((double) (target - position[i])) / speed[i], i};
        }

        Arrays.sort(ticks, (one, two) -> position[(int)two[1]] - position[(int)one[1]]);
        // now we've got count until target sorted by initial position, closest to target first

        Stack<double[]> s = new Stack<>();
        s.push(ticks[0]);
        for (int i = 1; i < ticks.length; i++) {
            // combine fleets: compare ticks, when ticks[i] <= ticks[j] && position[i] >= position[j];
            double[] top = s.peek();
            if (ticks[i][0] > top[0] && position[(int)ticks[i][1]] < position[(int)top[1]]) {
                s.push(ticks[i]);
            }
        }

        // StringBuilder sb = new StringBuilder("[");
        // for (double[] a : ticks) {
        //     sb.append(Arrays.toString(a));
        //     sb.append(", ");
        // }
        // sb.deleteCharAt(sb.length() -1);
        // sb.append("]");
        // System.out.println(sb.toString());

        return s.size();
    }
}

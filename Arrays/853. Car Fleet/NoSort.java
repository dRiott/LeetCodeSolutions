class NoSort {
    public int carFleet(int target, int[] position, int[] speed) {
        if (position.length == 0) return 0;
        
        float[] ticks = new float[target]; // use full distance as the ticks length, so we can put cars on the map
        for (int i = 0; i < position.length; i++) {
            // this ticks in position trick avoids a subsequent sort!
            ticks[position[i]] = ((float) (target - position[i])) / speed[i];
        }

        //Arrays.sort(ticks, (one, two) -> position[(int)two[1]] - position[(int)one[1]]);

        float prev = 0; // start from the end
        int ans = 0;
        for (int i = target - 1; i >= 0; i--) {
            // combine fleets: compare ticks, when ticks[i] <= ticks[j] && position[i] >= position[j];
            if (ticks[i] > prev) {
                prev = ticks[i];
                ans++;
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

        return ans;
    }
}

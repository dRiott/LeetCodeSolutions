class Combinatorics {
    private static final int MOD = (int) 1e9 + 7;
    public int numberOfWays(String corridor) {
        // corridor is chars 'S' (seat) or 'P' (plant)
        // add wall dividers to create sections, such that each section has two seats and any num plants
        // how many ways can we divide the corridor?

        //memo = new int[][];

        // for every plant between pairs of seats, you get p+1 possible divider locations
        // collect all of the pairs of seats, and the num plants between them?
        // calculate the possible wall locations for each pair, and multiply them together?
        // if you can't make pairs, then return 0, it's impossible to get exactly 2 seats

        long res = 0;
        char[] cor = corridor.toCharArray();
        int countSeats = 0;
        for (int i = 0; i < cor.length; i++) {
            if (cor[i] == 'S') {
                countSeats++;
            }
        }

        if (countSeats % 2 != 0) return 0;
        if (countSeats == 2) return 1;


        boolean seenPair = false;
        boolean pairStarted = false;
        long temp = 0;
        for (int i = 0; i < cor.length; i++) {
            char c = cor[i];
            if (c == 'S') {
                // seat is either opening or closing
                if (!pairStarted) {
                    pairStarted = true;
                    if (seenPair) {    
                        temp++; // final increment for combination of dividors
                        if (res == 0) {
                            res = temp;
                        } else {
                            res = (res * temp) % MOD;
                        }
                        temp = 0;
                        seenPair = false;
                    }
                } else {
                    pairStarted = false;
                    seenPair = true;
                }
            }
            if (c == 'P' && seenPair) {
                temp++;
            }
        }

        return (int) res;
    }
}

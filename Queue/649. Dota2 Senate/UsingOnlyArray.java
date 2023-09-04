class UsingOnlyArray {
    public String predictPartyVictory(String senate) {
        // vote in order
        // strat: try to eliminate the next opposite party
        // end of string: start at beginning next round
        

        char[] s = senate.toCharArray();
        String res = "";
        while ("".equals(res)) {
            res = performRound(s);
        }
        return res;
    }

    private String performRound(char[] s) {
        int r = 0;
        int d = 0;
        int seat = 0;

        while (seat < s.length) { // loop for round
            char myParty = s[seat]; // me
            int nextTurn = seat+1;

            // count yourself
            if (myParty == 'B') {
                seat++;
                continue;
            } else if (myParty == 'R') {
                r++;
            } else if (myParty == 'D') {
                d++;
            }

            // check going right until the end, or guy next to me should be banned.
            while (seat+1 < s.length && (s[seat+1] == 'B' || s[seat+1] == myParty)) {
                seat++; // next guy banned or in my party, skip
                if (myParty == 'R') {
                    r++;
                } else if (myParty == 'D') {
                    d++;
                }
            }

            // determine your action: declare or ban

            // if at the end, opportunity to declare victory
            if (seat+1 == s.length) {
                // reached end, can declare victory or still need to find bannable person
                if (myParty == 'R' && r > 0 && d == 0) {
                    return "Radiant";
                } else if (myParty == 'D' && d > 0 && r == 0) {
                    return "Dire";
                } else {
                    // find guy from beginning to ban
                    int beg = 0;
                    while (beg < s.length -1 && (s[beg] == 'B' || s[beg] == myParty)) {
                        beg++; // next guy banned or in my party, skip
                    }
                    s[beg] = 'B'; // ban guy from other party
                    
                    // decrement that party's count
                    if (myParty == 'R') {
                        d--;
                    } else {
                        r--;
                    }

                }
            } else {
                s[seat+1] = 'B'; // ban guy
            }
            seat = nextTurn;
        }
        return "";
    }
}

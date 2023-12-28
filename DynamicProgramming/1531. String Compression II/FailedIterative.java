class FailedIterative {
    // Whenever a problem asks us to minimize or maximize a result based on a given set of rules, 
    // we should always include dynamic programming in our list of approaches to consider.

    
    public int getLengthOfOptimalCompression(String s, int k) {
        // find the run-length encoded version of s
        // chars should be deleted ordered by their smallest counts, e.g. 1s, then 2s,
        // then 3s

        int[] freq = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            freq[c - 'a']++;
        }

        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>(Comparator.comparing(Pair::getValue));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                queue.offer(new Pair(i, freq[i]));
                char c = (char) (i + 'a');
                sb.append(c);
                if (freq[i] > 1) {
                    sb.append(freq[i]);
                }
            }
        }

        String comp = sb.toString();
        int len = comp.length();
        while (k > 0 && !queue.isEmpty()) {
            Pair<Integer, Integer> p = queue.poll();
            if (k - p.getValue() >= 0) {
                k -= p.getValue();
                // can remove entire letter and its count from encoding
                if (p.getValue() == 1) {
                    len -= 1;
                } else {
                    int digitCount = getDigitCount(p.getValue());
                    len -= (digitCount + 1); // one for the char, digit count for it's frequency
                }
            } else {
                // couldn't remove entire letter, can we remove k characters to bring string
                // compaction down?
                // i.e. from 10 -> 9 (removes one char), or from 111 -12 == 99, removes one char
                while (true) {

                    // 10 --> 2
                    // int divisor = (n-1)*10;
                    // vall - divisor = subK
                    // k -= subK;

                    int val = p.getValue();
                    int valDigits = getDigitCount(val);

                    int toConsume = (val - (valDigits-1)*10) + 1;

                    int valMinKDigits = getDigitCount(val - toConsume);
                    if (k-toConsume >= 0 && valMinKDigits < valDigits) {
                        len -= (valDigits - valMinKDigits);
                        k -= toConsume;
                    }
                    
                    if (queue.isEmpty()) break;
                    p = queue.poll();
                }
            }
        }

        return len;
    }

    private int getDigitCount(int val) {
        int count = 0;
        while (val > 0) {
            val /= 10;
            count++;
        }
        return count;
    }
}

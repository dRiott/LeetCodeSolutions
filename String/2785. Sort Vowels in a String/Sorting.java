class Sorting {
    public String sortVowels(String s) {
        // iterate through characters of s, building up priorityqueue vowels as ints
        // iterate through s again, replacing with pq.poll()
        
        Queue<Integer> pq = new PriorityQueue<>();
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                pq.offer((int) c);
            }
        }

        StringBuilder t = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); ++i) {
            if (isVowel(s.charAt(i))) {
                t.append((char) ((int) pq.poll()));
            } else {
                t.append(s.charAt(i));
            }
        }
        return t.toString();
    }

    private boolean isVowel(char c) {
        switch(c) {
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }
}


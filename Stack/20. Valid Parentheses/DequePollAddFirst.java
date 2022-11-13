class DequePollAddFirst {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;

        Deque<Character> queue = new ArrayDeque<>(s.length()/2);
        for (char c : s.toCharArray()) {
            if (c == ']' || c == '}' || c == ')') {
                Character top = queue.poll();
                if (top == null) return false;
                if (c == ']' && top != '[') return false;
                if (c == '}' && top != '{') return false;
                if (c == ')' && top != '(') return false;
            } else {
                queue.addFirst(c);
            }
        }
        return queue.isEmpty();
    }
}

class StackRemoveLast {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        String[] tokens = path.split("/");

        for (String t : tokens) {
            if (".".equals(t) || t.isEmpty()) continue;

            if ("..".equals(t)) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(t);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append("/");
            sb.append(stack.removeLast());
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }
}

/*
 * Learned:
 *   - Be careful. If you don't think about the problem's edge cases before you begin, you'll mess up.
 *       Here, I first used a end-->front approach, which isn't how the backspaces should be applied.
 *   - Reminder: StringBuilder has no deleteLast() operation, but you can use setLength(). 
 *       A Stack could be used instead, with String.valueOf(stack) to convert to String at the end.
 */
class BuildStrings {
    public boolean backspaceCompare(String s, String t) {

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) != '#') {
                sb.append(s.charAt(i));
            } else {
                sb.setLength(Math.max(0 , sb.length()-1));
            }
            i++;
        }

        String sEnd = sb.toString();
        
        sb.setLength(0);
        i = 0;
        while (i < t.length()) {
            if (t.charAt(i) != '#') {
                sb.append(t.charAt(i));
            } else {
                sb.setLength(Math.max(0 , sb.length()-1));
            }
            i++;
        }

        return sEnd.equals(sb.toString());
    }
}

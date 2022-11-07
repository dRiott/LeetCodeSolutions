class TwoPointer {
    public boolean isPalindrome(String s) {
        char[] c = s.toCharArray();
        
        int i = 0, j = c.length -1;
        while (i < j) {
            while (i < c.length && !Character.isLetterOrDigit(c[i])) ++i;
            while (j >= 0 && !Character.isLetterOrDigit(c[j])) --j;
            
            if (i < j && Character.toLowerCase(c[i]) != Character.toLowerCase(c[j])) return false;
            ++i;
            --j;
        }
        return true;
    }
}

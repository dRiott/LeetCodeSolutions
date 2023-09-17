class Solution {
    public int compress(char[] chars) {
        
        if (chars.length == 0 || chars.length == 1) {
            return 1;
        }

        int j = 0;
        for (int i = 0; i < chars.length; i++) {
            char cur = chars[i];
            
            
            int count = 1;
            while (i+1 != chars.length && cur == chars[i+1]) {
                i++;
                count++;
            }
            
            chars[j++] = chars[i];
            
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[j++] = c;
                }
            }
            
        }
        return j;
    }
}

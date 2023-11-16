class NotInSet {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        Set<Integer> vals = new HashSet<>();
        for (String s : nums) {
            vals.add(Integer.parseInt(s, 2));
        }
      
        for (int i = 0; i <= n; i++) {
            if (!vals.contains(i)) {
                // convert to string
                String res =  Integer.toBinaryString(i);
                if (res.length() == n) return res;
                    
                // not long enough, pad with zeros
                StringBuilder sb = new StringBuilder(res);
                while (sb.length() < n) sb.insert(0, '0');
                return sb.toString();        
            }
        }
        return "";
    }
}

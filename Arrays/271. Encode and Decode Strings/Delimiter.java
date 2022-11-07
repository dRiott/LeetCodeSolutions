public class Delimiter {

    private static final String DELIM = Character.toString((char)257);
  
    public String encode(List<String> strs) {
        // strs[i] contains any possible characters out of 256 valid ASCII characters... use the 267th as delimiter.
      
        StringBuilder sb = new StringBuilder();   
        for (String s : strs) {
            sb.append(s);
            sb.append(DELIM);
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public List<String> decode(String s) {
      // split with limit: empty strings not discarded
      return Arrays.asList(s.split(DELIM, -1));
    }
}

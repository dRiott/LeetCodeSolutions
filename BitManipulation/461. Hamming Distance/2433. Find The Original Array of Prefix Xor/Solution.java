/**
 * Learned:
 *   - An important property of XOR that we can use to solve this problem is a ^ a = 0
 *     i.e. the XOR of two same integers is equal to 0
 *   - If:   pref[i] = arr[0] ^ ... ^ arr[i]
 *   - Then: pref[i+1] = arr[0] ^ ... ^ arr[i] ^ arr[i+1]
 *   - Now combine them: pref[i] ^ pref[i+1] = (arr[0] ^ ... ^ arr[i]) ^ (arr[0] ^ ... ^ arr[i] ^ arr[i+1])
 *   - And rearrange so that arr[0] ^ arr[0] ^ ... ^
 *   - And you get pref[i] ^ pref[i+1] = 0 ^ 0 ^ ... ^ arr[i+1]
 *   - Which is equivalent to pref[i-1] ^ pref[i] = arr[i]
 */
class Solution {
    public int[] findArray(int[] pref) {
        // pref[0] == arr[0] ^ x
        // 10101   == ??? ^ ???
        // for zeros, both bits were the same, either 0 or 1
        /// for ones, both bits were different, and either could be either
        int[] res = new int[pref.length];
        
        // pref[1] = res[0] ^ ?

        // inspect pref[1]: e.g. 1100101
        // say res[0]:           0010101
        // search for: 1110011

        for (int i = 0; i < pref.length; i++) {
            if (i == 0) {
                res[i] = pref[i];
                continue;
            }

            res[i] = pref[i-1] ^ pref[i];// calculate me
            //int ans = pref[i];
            // how to get ans from x ^ res[i]?

            // iterated over the bits of ans, compared them to 
        }
        return res;

    }
}

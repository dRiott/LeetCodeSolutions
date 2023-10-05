class XorCountingRightMostBit {
  // number of positions at which corresponding bits are different
  public int hammingDistance(int x, int y) {
    int count = 0;
    int xorCurr = x ^ y; // bitwise xor, if corresponding bits are diff
    while (xorCurr != 0) {
      if (xorCurr % 2 == 1) { // odd numbers have right-most bit value of 1
        count++;
      }
      xorCurr = xorCurr >> 1; // shift all bits right one
    }
    return count;
  }
}

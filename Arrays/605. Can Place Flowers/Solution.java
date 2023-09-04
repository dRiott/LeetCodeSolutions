class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        for (int i = 0; i < flowerbed.length; i++) {
            int prev = i >= 1 ? flowerbed[i-1] : 0;
            int next = i+1 < flowerbed.length ? flowerbed[i+1] : 0;
            int curr = flowerbed[i];
            if (curr != 1 && prev == 0 && next == 0) {
                n--;
                flowerbed[i] = 1;
            }
        }

        return n <= 0;
    }
}

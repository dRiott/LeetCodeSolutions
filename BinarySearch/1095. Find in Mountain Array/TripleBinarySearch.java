/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 *
 * Learned: 
 * - Reminder: Binary search, int mid = left + (right - left) / 2; if move right, right = mid, else left = mid + 1
 * - Reminder: Be careful about off-by-one binary search gotcha
 */
class TripleBinarySearch {
    public int findInMountainArray(int target, MountainArray mountainArr) {

        // Strategy: three binary searches:
        // - Search for mountainArr peak, that becomes the right bound
        // - Search for target on the left side
        // - If still not found, search for target on the right side

        // find peak
        int left = 0, right = mountainArr.length() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            // optimization
            if (isTargetLeftSide(target, mid, mountainArr)) {
                return mid;
            }

            if (isDescending(mid, mountainArr)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        // peak is the target
        if (target == mountainArr.get(left)) {
            return left;
        }
        
        int left2 = 0, right2 = left;
        while (left2 < right2) {
            int mid = left2 + (right2 - left2) / 2;

            if (isLargerThanTarget(target, mid, mountainArr)) {
                right2 = mid;
            } else {
                left2 = mid + 1;
            }
        }

        int targetI = left2 - 1; // undo the final binary search index update
        boolean isTarget = isTarget(target, targetI, mountainArr);

        // search right side.
        if (!isTarget) {

            int l = left, r = mountainArr.length();
            while (l < r) {
                int mid = l + (r - l) / 2;

                if (isSmallerThanTarget(target, mid, mountainArr)) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            targetI = l-1; // undo the final binary search index update
            isTarget = isTarget(target, targetI, mountainArr);
        }

        return isTarget ? targetI : -1;
    }

    private boolean isTargetLeftSide(int target, int i, MountainArray mountainArr) {
        int val = mountainArr.get(i);
        return val == target && i+1 < mountainArr.length() && mountainArr.get(i+1) > val;
    }

    private boolean isDescending(int i, MountainArray mountainArr) {
        return i+1 < mountainArr.length() && mountainArr.get(i+1) < mountainArr.get(i);
    }

    private boolean isLargerThanTarget(int target, int i, MountainArray mountainArr) {
        return mountainArr.get(i) > target;
    }

    private boolean isSmallerThanTarget(int target, int i, MountainArray mountainArr) {
        return mountainArr.get(i) < target;
    }

    private boolean isTarget(int target, int i, MountainArray mountainArr) {
        return i >= 0 && i < mountainArr.length() && target == mountainArr.get(i);
    }
}

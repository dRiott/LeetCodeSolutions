class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        // if (sx == fx && sy==fy) {
        //     return false;
        // }

        // // options: move diagonally, or in a cardinal direction
        // int xDest = fx-sx;
        // int yDest = fy-sy;

        // // shortest path is moving diagonally until you reach the same column or row as (fx,fy)
        // int yDir = yDest < 0 ? -1 : 1;
        // int xDir = xDest < 0 ? -1 : 1;

        // int steps = 0;
        // while (sy != fy && sx != fx) {
        //     sx += xDir;
        //     sy += yDir;
        //     steps++;
        //     if (steps>t) return false;
        // }

        // while (sy != fy) {
        //     sy += yDir;
        //     steps++;
        //     if (steps>t) return false;
        // }

        // while (sx != fx) {
        //     sx += xDir;
        //     steps++;
        //     if (steps>t) return false;
        // }


        // return steps <= t;
        int width = Math.abs(sx - fx);
        int height = Math.abs(sy - fy);
        if (width == 0 && height == 0 && t == 1) {
            return false;
        }
        return t >= Math.max(width, height);
    }
}

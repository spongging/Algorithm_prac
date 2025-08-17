import java.util.*;

class Solution {
    private int n;
    private int m;
    
    public long solution(int n, int m, int x, int y, int[][] queries) {
        this.n = n;
        this.m = m;
        
        long left = y;
        long right = y;
        long top = x;
        long bottom = x;

        for (int i = queries.length - 1; i >= 0; i--) {
            int direction = queries[i][0];
            int dist = queries[i][1];

            if (direction == 0) {
                if (left != 0) 
                    left += dist;
                right = Math.min(m - 1, right + dist);
            } else if (direction == 1) {
                if (right != m - 1) 
                    right -= dist;
                left = Math.max(0, left - dist);
            } else if (direction == 2) { 
                if (top != 0) 
                    top += dist;
                bottom = Math.min(n - 1, bottom + dist);
            } else if (direction == 3) { 
                if (bottom != n - 1) 
                    bottom -= dist;
                top = Math.max(0, top - dist);
            }

            if (!check(left, right, top, bottom)) {
                return 0;
            }
        }

        return (right - left + 1) * (bottom - top + 1);
    }
    
    private boolean check(long left, long right, long top, long bottom){
        return left<m && right>=0 && top<n && bottom>=0;
    }
}
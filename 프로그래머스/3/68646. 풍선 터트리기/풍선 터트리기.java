import java.util.*;

class Solution {
    public int solution(int[] a) {
        int n = a.length;
        if (n <= 2) return n; // 풍선이 2개 이하이면 모두 남을 수 있음

        // 왼쪽 최소값 배열
        int[] leftMin = new int[n];
        leftMin[0] = a[0];
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], a[i]);
        }

        // 오른쪽 최소값 배열
        int[] rightMin = new int[n];
        rightMin[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], a[i]);
        }

        // 마지막까지 남을 수 있는 풍선 개수 계산
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] <= leftMin[i] || a[i] <= rightMin[i]) {
                answer++;
            }
        }

        return answer;
    }
}

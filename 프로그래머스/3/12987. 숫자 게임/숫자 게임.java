import java.util.*;

class Solution {
    private boolean[] visited;

    public int solution(int[] A, int[] B) {
        Arrays.sort(B);                 // B 오름차순 정렬
        visited = new boolean[B.length];

        int score = 0;
        int minIdx = 0; // "가장 작은 B"를 가리키는 포인터

        for (int i = 0; i < A.length; i++) {
            int biggerIdx = findBiggerElementIdx(A[i], B);

            if (biggerIdx == -1) {
                // A[i]를 이길 카드가 없다면
                // B 중 가장 작은 카드 하나를 소모(= visited 처리)
                while (minIdx < B.length && visited[minIdx]) {
                    minIdx++;
                }
                if (minIdx < B.length) {
                    visited[minIdx] = true;
                }
            } else {
                // 찾은 biggerIdx 카드로 승리
                visited[biggerIdx] = true;
                score++;
            }
        }
        return score;
    }

    // B에서 (값 > target)인 원소 중 가장 작은 인덱스를 찾는다.
    private int findBiggerElementIdx(int target, int[] B) {
        int left = 0;
        int right = B.length - 1;
        int idx = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (B[mid] > target) {
                idx = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (idx == -1) {
            return -1; // B 중 target보다 큰 게 아예 없음
        }

        // idx부터 오른쪽으로 가면서 아직 방문되지 않은(visited=false) 
        // 그리고 값이 target보다 큰 인덱스 찾기
        for (int i = idx; i < B.length; i++) {
            if (!visited[i] && B[i] > target) {
                return i;
            }
        }

        return -1; // 사용 가능한 카드가 없음
    }
}

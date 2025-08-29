import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        new Solution().solution();
    }
}

class Solution {
    private int N, M;
    private final ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private final ArrayList<Integer> answerArr = new ArrayList<>();
    private int maxCnt = -1;

    // 방문 배열 재활용(태깅 기법)
    private int[] seen;      // seen[v] == stamp 면 방문한 것
    private int stamp = 1;   // 매 시작점마다 +1

    public void solution() throws Exception {
        inputAndInit();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            int cnt = bfsCount(i);   // 반복형 BFS
            if (cnt > maxCnt) {
                maxCnt = cnt;
                answerArr.clear();
                answerArr.add(i);
            } else if (cnt == maxCnt) {
                answerArr.add(i);
            }
        }

        for (int x : answerArr) sb.append(x).append(' ');
        System.out.print(sb.toString());
    }

    private int bfsCount(int start) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        seen[start] = stamp;
        q.add(start);
        int cnt = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nxt : graph.get(cur)) {
                if (seen[nxt] != stamp) {
                    seen[nxt] = stamp;
                    q.add(nxt);
                    cnt++;
                }
            }
        }
        stamp++;  // 다음 시작점에서 새 방문 라운드 시작
        return cnt;
    }

    private void inputAndInit() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 반전 간선: b를 해킹하면 a도 가능 → b -> a
            graph.get(b).add(a);
        }

        seen = new int[N + 1];
    }
}

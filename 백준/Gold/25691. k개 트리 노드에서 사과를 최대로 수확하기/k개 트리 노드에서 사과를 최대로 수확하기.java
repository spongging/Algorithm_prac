import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] apple;
    static List<Integer>[] tree;
    // dp[u][x] = u를 루트로 하는 서브트리에서 서로 다른 x개 노드를
    // 선택했을 때 얻을 수 있는 최대 사과 합
    static long[][] dp;
    // 불가능 상태 표시용 (사과 개수는 0 이상이므로 이보다 작은 음수로)
    static final long NEG = Long.MIN_VALUE / 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 1) 트리 구성 (0번부터 N-1번)
        tree = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }

        // 2) 사과 입력 (간선 정보 다음 줄)
        apple = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            apple[i] = Integer.parseInt(st.nextToken());
        }

        // 3) DP 배열 초기화
        dp = new long[N][K + 1];
        for (int u = 0; u < N; u++) {
            Arrays.fill(dp[u], NEG);
            dp[u][1] = apple[u];  // 자기 자신만 선택했을 때
        }

        // 4) 후위 순회로 DP 채우기
        dfs(0, -1);

        // 5) 루트(0)에서 1..K개 선택 시 최댓값
        long ans = 0;
        for (int x = 1; x <= K; x++) {
            ans = Math.max(ans, dp[0][x]);
        }
        System.out.println(ans);
    }

    // u: 현재 노드, p: 부모 노드
    static void dfs(int u, int p) {
        for (int v : tree[u]) {
            if (v == p) continue;
            dfs(v, u);

            // u서브트리의 기존 dp[u]를 newDp에 복사
            long[] newDp = Arrays.copyOf(dp[u], K + 1);

            // knapsack 병합: j = u쪽에서 선택한 개수, t = v쪽에서 추가 선택 개수
            for (int j = 1; j <= K; j++) {
                if (dp[u][j] < 0) continue;           // 불가능 상태 건너뜀
                for (int t = 1; j + t <= K; t++) {
                    if (dp[v][t] < 0) continue;       // 불가능 상태 건너뜀
                    long candidate = dp[u][j] + dp[v][t];
                    if (candidate > newDp[j + t]) {
                        newDp[j + t] = candidate;
                    }
                }
            }

            // 병합 결과를 dp[u]에 반영
            dp[u] = newDp;
        }
    }
}

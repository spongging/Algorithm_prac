import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] grid = new char[N][M];
        for (int i = 0; i < N; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        // 1) 각 행별 흰/파랑/빨강으로 칠할 때 비용 계산
        int[] costW = new int[N], costB = new int[N], costR = new int[N];
        for (int i = 0; i < N; i++) {
            int w = 0, b = 0, r = 0;
            for (int j = 0; j < M; j++) {
                char c = grid[i][j];
                if (c != 'W') w++;
                if (c != 'B') b++;
                if (c != 'R') r++;
            }
            costW[i] = w;
            costB[i] = b;
            costR[i] = r;
        }

        // 2) 구간 분할 시도 및 최소 비용 계산
        int answer = Integer.MAX_VALUE;

        // i: 흰색 구간의 마지막 행 인덱스 (0 ≤ i ≤ N-3)
        // j: 파랑 구간의 마지막 행 인덱스 (i+1 ≤ j ≤ N-2)
        for (int i = 0; i <= N - 3; i++) {
            for (int j = i + 1; j <= N - 2; j++) {
                int cost = 0;
                // 흰색 구간
                for (int x = 0; x <= i; x++) cost += costW[x];
                // 파랑 구간
                for (int x = i + 1; x <= j; x++) cost += costB[x];
                // 빨강 구간
                for (int x = j + 1; x < N; x++) cost += costR[x];

                answer = Math.min(answer, cost);
            }
        }

        System.out.println(answer);
    }
}

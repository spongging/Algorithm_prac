import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N;
    private int[][] arr;
    private int limit;
    private boolean[] visited;
    private int answer = Integer.MAX_VALUE;

    public void solution() throws IOException {
        input();

        for (int i = 1; i < N - 1; i++) {
            limit = i;
            backTracking(0, 0);
        }

        output();
    }

    private void output() {
        System.out.println(answer);
    }

    private void backTracking(int idx, int level) {
        if (level == limit) {
            int linkNumberSum = 0;
            int startNumberSum = 0;

            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (visited[i] && visited[j]) { // 링크 소속
                        linkNumberSum += (arr[i][j] + arr[j][i]);
                    } else if (!visited[i] && !visited[j]) { // 스타트 소속
                        startNumberSum += (arr[i][j] + arr[j][i]);
                    }
                }
            }

            answer = Math.min(answer, Math.abs(linkNumberSum - startNumberSum));
        }

        for (int i = idx + 1; i < N; i++) {
            visited[i] = true;
            backTracking(i, level + 1);
            visited[i] = false;
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");

            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }

        visited = new boolean[N];
    }
}
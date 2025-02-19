import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private char[][] arr;
    private int R;
    private int C;
    private int[] da = {0, 0, 1, -1};
    private int[] db = {1, -1, 0, 0};
    private Set<Character> s = new HashSet<>();
    private int answer = 0;

    public void solution() throws IOException {
        input();
        s.add(arr[0][0]);
        dfs(0, 0, 1);
        output();
    }

    private void dfs(int a, int b, int count) {
        answer = Math.max(answer, count);

        for (int i = 0; i < 4; i++) {
            int na = a + da[i];
            int nb = b + db[i];

            if (na >= 0 && na < R && nb >= 0 && nb < C) {
                if (s.contains(arr[na][nb])) {
                    continue;
                }

                s.add(arr[na][nb]);
                dfs(na, nb, count + 1);
                s.remove(arr[na][nb]);
            }
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();

            for (int j = 0; j < C; j++) {
                arr[i][j] = line.charAt(j);
            }
        }
    }

    private void output() {
        System.out.println(answer);
    }
}
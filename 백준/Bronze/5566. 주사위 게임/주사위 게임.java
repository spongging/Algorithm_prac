import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N, M;

    private final ArrayList<Integer> map = new ArrayList<>();
    private final ArrayList<Integer> diceArr = new ArrayList<>();

    public void solution() throws IOException {
        input();
        output(getAnswer());
    }

    private int getAnswer() {
        int cnt = 0;
        int tmpDist = 0;

        for (int n : diceArr) {
            cnt++;
            tmpDist += n;

            if (tmpDist >= N - 1) {
                break;
            }

            int order = map.get(tmpDist);

            if (order < 0) {
                tmpDist -= Math.abs(order);
            } else if (order > 0) {
                tmpDist += order;
            }

            if (tmpDist >= N - 1) {
                break;
            }
            
        }

        return cnt;
    }

    private void output(int answer) {
        System.out.println(answer);
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        for (int i = 0; i < N; i++) {
            map.add(Integer.parseInt(br.readLine().trim()));
        }

        for (int i = 0; i < M; i++) {
            diceArr.add(Integer.parseInt(br.readLine().trim()));
        }
    }
}
import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N;
    private ArrayList<Pair> pairArrayList = new ArrayList<>();
    private int[] edArr;
    private int[] dp;
    private int answer = 0;

    public void solution() throws IOException {
        input();
        init();
        doDP();
        output();
    }

    private void output() {
        System.out.println(N - answer);
    }

    private void init() {
        pairArrayList.sort(Comparator.comparingInt(Pair::getSt));
        dp = new int[N];
        edArr = new int[N];

        for (int i = 0; i < pairArrayList.size(); i++) {
            Pair pair = pairArrayList.get(i);
            edArr[i] = pair.getEd();
        }
    }

    private void doDP() {
        for (int i = 0; i < N; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (edArr[i] > edArr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for (int num : dp) {
            answer = Math.max(answer, num);
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            pairArrayList.add(new Pair(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
        }

    }
}

class Pair {
    int st;
    int ed;

    public Pair(int st, int ed) {
        this.st = st;
        this.ed = ed;
    }

    public int getSt() {
        return st;
    }

    public int getEd() {
        return ed;
    }
}


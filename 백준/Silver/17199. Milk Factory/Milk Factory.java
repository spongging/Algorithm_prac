import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N;

    private final ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    private final HashMap<Integer, Integer> map = new HashMap<>();

    public void solution() throws IOException {
        inputAndInit();

        for (int i = 1; i <= N; i++) {
            map.put(i, map.get(i) + 1);
            dfs(i);
        }

        output(getAnswer());
    }

    private void output(int answer) {
        System.out.println(answer);
    }

    private void dfs(int v) {
        for (int i = 0; i < arr.get(v).size(); i++) {
            int next = arr.get(v).get(i);
            map.put(next, map.get(next) + 1);
            dfs(next);
        }
    }

    private int getAnswer() {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == N) {
                return entry.getKey();
            }
        }

        return -1;
    }

    private void inputAndInit() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i <= N; i++) {
            map.put(i, 0);
        }

        for (int i = 0; i < N - 1; i++) {
            String[] line = br.readLine().split(" ");
            arr.get(Integer.parseInt(line[0])).add(Integer.parseInt(line[1]));
        }
    }
}
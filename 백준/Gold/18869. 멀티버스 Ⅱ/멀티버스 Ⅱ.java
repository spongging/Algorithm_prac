import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private static int M, N;
    private static int answer;
    private ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    private ArrayList<ArrayList<Integer>> resultArr = new ArrayList<>();

    public void solution() throws IOException {
        input();
        find();
        counting();
        output();
    }

    private void output() {
        System.out.println(answer);
    }

    private void counting() {
        for (int i = 0; i < M; i++) {
            for (int j = i + 1; j < M; j++) {
                if (Arrays.equals(resultArr.get(i).toArray(), resultArr.get(j).toArray())) {
                    answer++;
                }
            }
        }
    }

    private void find() {
        for (int i = 0; i < M; i++) {
            Set<Integer> set = new HashSet<>();
            ArrayList<Integer> space = arr.get(i);

            for (int j = 0; j < N; j++) {
                set.add(space.get(j));
            }

            ArrayList<Integer> spaceIdx = new ArrayList<>(set);
            Collections.sort(spaceIdx);

            for (int j = 0; j < N; j++) {
                int idx = Collections.binarySearch(spaceIdx, space.get(j));
                space.set(j, idx);
            }

            resultArr.add(space);
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        M = Integer.parseInt(line[0]);
        N = Integer.parseInt(line[1]);

        for (int i = 0; i < M; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr.get(i).add(Integer.parseInt(line[j]));
            }
        }
    }
}
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N;

    private final static ArrayList<Integer> nums = new ArrayList<>();
    private final static ArrayList<Long> sums = new ArrayList<>();

    public void solution() throws IOException {
        input();
        getSums();
        output(getAnswer());
    }

    private void output(long answer) {
        System.out.println(answer);
    }

    private long getAnswer() {
        for (int i = N - 1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                long sub = nums.get(i) - nums.get(j);

                if (Collections.binarySearch(sums, sub) >= 0) {
                    return nums.get(i);
                }
            }
        }

        return -1;
    }

    private void getSums() {
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                sums.add((long) (nums.get(i) + nums.get(j)));
            }
        }

        Collections.sort(sums);
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            nums.add(Integer.parseInt(st.nextToken()));
        }
        
        Collections.sort(nums);

        br.close();
    }
}
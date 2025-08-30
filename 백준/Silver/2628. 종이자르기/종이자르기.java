import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    int N, M, K;

    private final static ArrayList<Integer> arr0 = new ArrayList<>();
    private final static ArrayList<Integer> heigths = new ArrayList<>();
    private final static ArrayList<Integer> widths = new ArrayList<>();
    private final static ArrayList<Integer> arr1 = new ArrayList<>();

    public void solution() throws IOException {
        input();
        getWidth();
        getHeight();
        output(getAnswer());
    }

    private int getAnswer() {
        return heigths.get(heigths.size() - 1) * widths.get(widths.size() - 1);
    }

    private void output(int answer) {
        System.out.println(answer);
    }

    private void getHeight() {
        int tmp = 0;

        for (int n : arr0) {
            heigths.add(n - tmp);
            tmp = n;
        }

        Collections.sort(heigths);
    }

    private void getWidth() {
        int tmp = 0;

        for (int n : arr1) {
            widths.add(n - tmp);
            tmp = n;
        }

        Collections.sort(widths);
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            if (n1 == 0) {
                arr0.add(n2);
            } else arr1.add(n2);
        }

        arr0.add(N);
        arr1.add(M);

        Collections.sort(arr0);
        Collections.sort(arr1);

        br.close();
    }
}
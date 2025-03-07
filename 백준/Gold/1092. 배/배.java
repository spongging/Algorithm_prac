import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N;
    private int M;
    private int answer = 0;
    private ArrayList<Integer> craneArr = new ArrayList<>();
    private ArrayList<Integer> boxArr = new ArrayList<>();

    public void solution() throws IOException {
        input();
        carryingBox();
        output(answer);
    }

    private void carryingBox() {
        if (craneArr.get(0) < boxArr.get(0)) {
            answer = -1;
            return;
        }

        while (!boxArr.isEmpty()) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < boxArr.size(); j++) {
                    if (craneArr.get(i) >= boxArr.get(j)) {
                        boxArr.remove(j);
                        break;
                    }
                }
            }

            answer++;
        }


    }

    private void output(int answer) {
        System.out.println(answer);
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        String[] line = br.readLine().split(" ");
        for (String s : line) {
            craneArr.add(Integer.parseInt(s));
        }

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st2.nextToken());

        line = br.readLine().split(" ");
        for (String s : line) {
            boxArr.add(Integer.parseInt(s));
        }

        craneArr.sort(Collections.reverseOrder());
        boxArr.sort(Collections.reverseOrder());
    }
}



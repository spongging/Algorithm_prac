import java.io.*;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N;
    private ArrayList<Integer> arrayList = new ArrayList<>();
    private Stack<Integer> stack = new Stack<>();
    private int answer = 0;

    public void solution() throws IOException {
        input();
        findBuilding();
        output();
    }

    private void findBuilding() {
        for (int i = 0; i <= N; i++) {
            int target = arrayList.get(i);

            if ( target > stack.peek()) {
                stack.add(arrayList.get(i));
                continue;
            }

            if (target == 0) {
                while (true) {
                    if (stack.peek()==0) break;

                    stack.pop();
                    answer++;
                }
                continue;
            }

            if (stack.peek() > target) {
                while (stack.peek() > target) {
                    stack.pop();
                    answer++;
                }
                if (!stack.contains(target)) {
                    stack.add(target);
                }
            }
        }
    }

    private void output() {
        System.out.println(answer);
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            arrayList.add(Integer.parseInt(line[1]));
        }
        arrayList.add(0);
        stack.add(0);
    }
}


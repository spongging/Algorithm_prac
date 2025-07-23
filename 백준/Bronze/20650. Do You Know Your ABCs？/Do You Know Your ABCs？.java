import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private final ArrayList<Integer> arr = new ArrayList<>();
    int a,b, c;

    public void solution() throws IOException {
        input();
        getAnswer();
        output();
    }

    private void output() {
        System.out.println(a + " " + b + " " + c);
    }

    private void getAnswer() {
        a = arr.get(0);
        b = arr.get(1);
        int sum = arr.get(arr.size() - 1);
        c = sum - a - b;
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        for (String s : line) {
            arr.add(Integer.parseInt(s));
        }

        Collections.sort(arr);
    }
}
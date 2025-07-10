import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N, P, W, L, G;
    private Map<String, Character> map = new HashMap<>();
    private ArrayList<String> arr = new ArrayList<>();


    public void solution() throws IOException {
        input();
        output(playGame());
    }

    private void output(boolean isWin) {
        if (isWin) {
            System.out.println("I AM NOT IRONMAN!!");
        } else {
            System.out.println("I AM IRONMAN!!");
        }
    }

    private boolean playGame() {
        int curPoint = 0;

        for (String player : arr) {
            if (!map.containsKey(player)) {
                curPoint -= L;
                if (curPoint < 0) {
                    curPoint = 0;
                }

            } else {
                Character c = map.get(player);
                if (c == 'W') {
                    curPoint += W;

                } else {
                    curPoint -= L;
                    if (curPoint < 0) {
                        curPoint = 0;
                    }
                }
            }

            if (curPoint >= G) {
                return true;
            }
        }

        return false;
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        P = Integer.parseInt(line[1]);

        line = br.readLine().split(" ");

        W = Integer.parseInt(line[0]);
        L = Integer.parseInt(line[1]);
        G = Integer.parseInt(line[2]);

        for (int i = 0; i < P; i++) {
            line = br.readLine().split(" ");
            map.put(line[0], line[1].charAt(0));
        }

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            arr.add(s);
        }
    }
}
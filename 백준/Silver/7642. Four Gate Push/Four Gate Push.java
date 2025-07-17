import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int M,G,Z,S, E;
    private int answer;

    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void solution() throws IOException {
        while (input()) {
            for (int y = 0; y <= 5000; y++) {
                if (50 * y > G) break;

                for (int z = 0; z <= 5000; z++) {
                    if (50 * y + 100 * z > G) break;

                    for (int x = 0; x <= 5000; x++) {
                        if (100 * x + 125 * y + 50 * z > M) break;

                        answer = Math.max(answer, Z * x + S * y + E * z);
                    }
                }
            }

            System.out.println(answer);
        }
    }

    private boolean input() throws IOException {
        String[] line = br.readLine().split(" ");

        M = Integer.parseInt(line[0]);
        G = Integer.parseInt(line[1]);
        Z = Integer.parseInt(line[2]);
        S = Integer.parseInt(line[3]);
        E = Integer.parseInt(line[4]);

        answer = 0;

        return M != 0 || G != 0 || Z != 0 || S != 0 || E != 0;
    }
}
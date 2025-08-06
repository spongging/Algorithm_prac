import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder out = new StringBuilder();
        while (!(line = br.readLine()).equals("0 0 0")) {
            StringTokenizer st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken()); // 0: painting bottom-right is black, 1: white

            // 8×8 체스판을 놓을 수 있는 bottom-right 위치의 가로/세로 선택지 개수
            long A = n - 7;
            long B = m - 7;

            // P = (n+m) mod 2
            int P = (n + m) & 1;

            // 원하는 (a+b)%2 값: c==1이면 P, c==0이면 1-P
            int want = (c == 1 ? P : 1 - P);

            // a=1..A, b=1..B 중 (a+b)%2 == want 인 쌍의 개수 구하기
            // 홀수 개수, 짝수 개수 계산
            long oddA  = (A + 1) / 2;
            long evenA = A / 2;
            long oddB  = (B + 1) / 2;
            long evenB = B / 2;

            long result;
            if (want == 0) {
                // (a+b) 짝수: (oddA*oddB + evenA*evenB)
                result = oddA * oddB + evenA * evenB;
            } else {
                // (a+b) 홀수: (oddA*evenB + evenA*oddB)
                result = oddA * evenB + evenA * oddB;
            }

            out.append(result).append('\n');
        }
        System.out.print(out);
    }
}

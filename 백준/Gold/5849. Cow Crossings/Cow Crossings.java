import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        
        // 1) (a,b) 쌍 읽어서 배열에 저장
        int[][] cows = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cows[i][0] = Integer.parseInt(st.nextToken());  // a_i
            cows[i][1] = Integer.parseInt(st.nextToken());  // b_i
        }
        
        // 2) a 오름차순으로 정렬
        Arrays.sort(cows, Comparator.comparingInt(pair -> pair[0]));
        
        // 3) b 값만 뽑아서 B 배열 구성
        int[] B = new int[N];
        for (int i = 0; i < N; i++) {
            B[i] = cows[i][1];
        }
        
        // 4) prefix max P 계산
        int[] P = new int[N];
        P[0] = B[0];
        for (int i = 1; i < N; i++) {
            P[i] = Math.max(P[i - 1], B[i]);
        }
        
        // 5) suffix min S 계산
        int[] S = new int[N];
        S[N - 1] = B[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            S[i] = Math.min(S[i + 1], B[i]);
        }
        
        // 6) 각 소의 안전 여부 판정
        int safeCount = 0;
        for (int i = 0; i < N; i++) {
            boolean leftOk  = (i == 0)    || (P[i - 1] < B[i]);
            boolean rightOk = (i == N - 1) || (B[i] < S[i + 1]);
            if (leftOk && rightOk) {
                safeCount++;
            }
        }
        
        // 7) 결과 출력
        System.out.println(safeCount);
    }
}

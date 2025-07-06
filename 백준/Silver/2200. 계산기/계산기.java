import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // a[0]…a[N]: 최고차항(a[0]=1)부터 상수항(a[N])까지
        long[] a = new long[N + 1];
        for (int i = 0; i <= N; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }

        long presses = 0;
        // 1) 'x' 한 번 누르기
        presses += 1;

        // 2) Horner 방식: (…((x + a1) * x + a2) * x … + aN)
        //    - 덧셈은 모든 a[i]>0에 대해 '+', 자리수 만큼
        //    - 곱셈은 (N-1)번 '×' + 'x'
        // 덧셈 부분: a[1]…a[N] (a[0]은 1이므로 생략)
        for (int i = 1; i <= N; i++) {
            long coeff = a[i];
            if (coeff > 0) {
                presses += 1;              // '+'
                presses += digitCount(coeff);
            }
        }
        // 곱셈 부분: Horner 중간 단계에서 x 로 곱하는 연산은 (N-1)번
        if (N >= 1) {
            presses += 2L * (N - 1);       // 각 단계마다 '×'(1) + 'x'(1)
        }

        // 3) '=' 한 번
        presses += 1;

        System.out.println(presses);
    }

    // 숫자 키 입력 횟수 = 자릿수
    private static int digitCount(long x) {
        int cnt = 0;
        while (x > 0) {
            cnt++;
            x /= 10;
        }
        return cnt == 0 ? 1 : cnt;
    }
}

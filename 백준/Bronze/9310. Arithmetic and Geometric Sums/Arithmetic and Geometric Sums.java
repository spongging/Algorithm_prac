import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            int N = Integer.parseInt(line.trim());
            if (N == 0) break;  // 입력 종료

            StringTokenizer st = new StringTokenizer(br.readLine());
            BigInteger a1 = new BigInteger(st.nextToken());
            BigInteger a2 = new BigInteger(st.nextToken());
            BigInteger a3 = new BigInteger(st.nextToken());

            BigInteger sum;
            // 등차수열인지 판별: a2 - a1 == a3 - a2
            BigInteger diff1 = a2.subtract(a1);
            BigInteger diff2 = a3.subtract(a2);
            if (diff1.equals(diff2)) {
                // 등차수열: S_n = n*(2*a1 + (n-1)*d) / 2
                BigInteger n = BigInteger.valueOf(N);
                BigInteger d = diff1;
                BigInteger twoA1 = a1.multiply(BigInteger.valueOf(2));
                BigInteger term = twoA1.add(d.multiply(n.subtract(BigInteger.ONE)));
                sum = n.multiply(term).divide(BigInteger.valueOf(2));
            } else {
                // 등비수열: S_n = a1 * (r^n - 1) / (r - 1)
                // r = a2 / a1 (문제에서 r은 정수라고 가정)
                BigInteger r = a2.divide(a1);
                BigInteger n = BigInteger.valueOf(N);
                if (r.equals(BigInteger.ONE)) {
                    // r == 1 이면 모든 항이 a1
                    sum = a1.multiply(n);
                } else {
                    BigInteger rPowN = r.pow(N);
                    sum = a1.multiply(rPowN.subtract(BigInteger.ONE))
                             .divide(r.subtract(BigInteger.ONE));
                }
            }

            System.out.println(sum);
        }
    }
}

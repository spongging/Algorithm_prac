class Solution {
    public int solution(int n) {
        int sum = 0;

        // 약수 찾기: 1부터 n까지 반복
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) { // i가 n의 약수인지 확인
                sum += i;
            }
        }

        return sum;
    }
}

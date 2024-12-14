class Solution {
    public boolean solution(int x) {
        int sum = 0;  // 자릿수의 합을 저장할 변수
        int temp = x; // 입력값 x를 변경하지 않기 위해 temp 사용

        // 자릿수의 합 계산
        while (temp > 0) {
            sum += temp % 10; // 마지막 자릿수를 더함
            temp /= 10;       // 마지막 자릿수를 제거
        }

        // 하샤드 수 여부 판단
        return x % sum == 0;  // x가 자릿수의 합으로 나누어 떨어지면 true
    }
}

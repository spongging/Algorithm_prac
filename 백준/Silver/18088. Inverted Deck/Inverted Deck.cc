#include <iostream>
#include <vector>

using namespace std;

long long get_value(const vector<long long>& v, int i, int l, int r) {
    // 뒤집어진 부분 수열의 값을 반환하는 함수
    if(i >= l && i <= r) {
        return v[r - (i - l)];
    } else {
        return v[i];
    }
}

int main() {
    ios::sync_with_stdio(false); // 입출력 속도 향상
    cin.tie(nullptr);

    int n;
    cin >> n;
    vector<long long> v(n);
    for(int i = 0; i < n; ++i){
        cin >> v[i];
    }

    int l = -1, r = -1;
    // 첫 번째 감소 지점 찾기
    for(int i = 0; i < n -1; ++i){
        if(v[i] > v[i+1]){
            l = i;
            break;
        }
    }

    if(l == -1){
        // 이미 정렬된 경우
        cout << "1 1\n";
        return 0;
    }

    // 마지막 감소 지점 찾기
    for(int i = n -2; i >= 0; --i){
        if(v[i] > v[i+1]){
            r = i +1;
            break;
        }
    }

    // l을 왼쪽으로 확장
    while(l > 0 && v[l-1] == v[l]){
        l--;
    }

    // r을 오른쪽으로 확장
    while(r +1 < n && v[r] == v[r+1]){
        r++;
    }

    // 뒤집은 후 배열이 정렬되는지 확인
    bool is_sorted = true;
    for(int i = 0; i < n -1; ++i){
        long long a = get_value(v, i, l, r);
        long long b = get_value(v, i+1, l, r);
        if(a > b){
            is_sorted = false;
            break;
        }
    }

    if(is_sorted){
        // 결과 출력 (1-based index)
        cout << l+1 << ' ' << r+1 << '\n';
    } else {
        cout << "impossible\n";
    }

    return 0;
}

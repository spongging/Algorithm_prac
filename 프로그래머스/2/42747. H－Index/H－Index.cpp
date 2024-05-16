#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> citations) {
    sort(citations.begin(), citations.end());
    int answer = 0;
    for(int i = 0 ; i <= citations[citations.size()-1] ; i++){
        int init = i;
        int cnt = 0;
        for(int j = 0 ; j<citations.size(); j++){
            if(init <= citations[j]) cnt++;
        }
        if(init<=cnt) answer = init;
    }
    return answer;
}
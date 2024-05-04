#include <string>
#include <vector>

using namespace std;

int solution(vector<int> common) {
    int answer = 0;
    bool TF = 0;
    int a = common[0];
    int b = common[1];
    int c = common[2];
    int tmp1 = b-a;
    int tmp2 = c-b;
    if(tmp1==tmp2) TF = 1;
    if(TF){
        answer = common[common.size()-1]+tmp1;
    }
    else{
        int tmp = b/a;
        answer = common[common.size()-1]*tmp;
    }
    return answer;
}
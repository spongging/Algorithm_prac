#include <string>
#include <vector>

using namespace std;

int solution(int n, int m, vector<int> section) {
    int answer = 0; int tmp = section[0];
    if(section.size()==1){
        return 1;
    }
    for(int i = 1; i < section.size(); i++){
        if(section[i]<tmp+m) continue;
        tmp = section[i];
        answer++;
    }
    
    return ++answer;
}



#include <string>
#include <vector>

using namespace std;
string result;
char arr[5] = {'A','E','I','O','U'};
int answer = 0;
int cnt = 0;
void dfs(int level, string s){
    if(s==result){
        answer = cnt;
        return;
    }
    if(level==5) return;
    
    for(int i = 0; i<5; i++){
        cnt++;
        s+=arr[i];
        dfs(level+1,s);
        if(answer!=0) return;
        s.pop_back();
    }
}
int solution(string word) {
    result = word;
    dfs(0,"");
    return answer;
}
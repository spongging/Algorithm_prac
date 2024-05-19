#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(int k, vector<vector<int>> dungeons) {
    vector<int>v;
    int answer = -1;
    for(int i = 0 ; i< dungeons.size(); i++){
        v.push_back(i);
    }
    do{
        int tmpk = k;
        int tmpanswer = 0;
        for(int i = 0 ; i<v.size() ; i++){
            int idx = v[i];
            if(tmpk>=dungeons[idx][0]){
                tmpk -= dungeons[idx][1];
                tmpanswer++;
            }
            else break;
        }
        answer = max(answer,tmpanswer);
	}while(next_permutation(v.begin(),v.end()));
    
    return answer;
}
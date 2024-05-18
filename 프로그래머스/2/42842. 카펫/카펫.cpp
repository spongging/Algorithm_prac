#include <string>
#include <vector>

using namespace std;

vector<int> solution(int brown, int yellow) {
    vector<int> answer;
    int sum = brown + yellow;
    vector<int>v;
    for(int i = 1 ; i<=sum ; i++){
        if(sum%i==0){
            v.push_back(i);
            
            int tmp1 = i;
            int tmp2 = sum/i;
            
            if(tmp1>=tmp2 &&(tmp1-2)*(tmp2-2)==yellow){
                answer.push_back(tmp1);
                answer.push_back(tmp2);
            }
            
        }
    }
  
    return answer;
}
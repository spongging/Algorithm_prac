#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<vector<int>> routes) {
    int answer = 0;
    sort(routes.begin(), routes.end());
    int point = routes[0][1];
    for(int i = 1 ; i<routes.size(); i++){
        if(routes[i][0]>point){
            answer++;
            point = routes[i][1];
        }
        if(routes[i][1]<point){
            point = routes[i][1];
        }
    }
    answer++;
    return answer;
}
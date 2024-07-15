#include <iostream>
#include <vector>
#include <climits>
using namespace std;

int dist[51];
int solution(int N, vector<vector<int> > road, int K) {
    
    for(int i = 0 ; i<=50 ; i++){
        dist[i] = 2147000000;
    }
    dist[1] = 0;
    int answer = 0;
    
    for(int i = 1 ; i<=N ; i++){
        for(int j = 0 ; j<road.size() ; j++){
            int s = road[j][0];
            int e = road[j][1];
            int w = road[j][2];
            if(dist[s]!=2147000000 && dist[s] + w < dist[e]){
                dist[e] = dist[s] + w;
            }
            if(dist[e]!=2147000000 && dist[e] + w < dist[s]){
                dist[s] = dist[e] + w;
            }
        }
    }
    

    for(int i = 1 ; i<=N ; i++){
        
        if(dist[i]<=K) answer++;
    }
    
    // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.

    return answer;
}


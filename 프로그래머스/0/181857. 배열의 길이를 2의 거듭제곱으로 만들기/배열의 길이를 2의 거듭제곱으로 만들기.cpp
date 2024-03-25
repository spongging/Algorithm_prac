#include <string>
#include <vector>
#include <cmath>

using namespace std;

vector<int> solution(vector<int> arr) {
    vector<int> answer;
    int tmp ;
    int arr2[11] = {1,2,4,8,16,32,64,128,256,512,1024};
    for(int i = 0; i<=10; i++){
        if(arr.size()<=arr2[i]){
            tmp = arr2[i]-arr.size();
            break;
        }
    }
    for(int i = 0; i<tmp; i++){
        arr.push_back(0);
    }
    for(int i = 0; i<arr.size(); i++){
        answer.push_back(arr[i]);
    }
    
    return answer;
}
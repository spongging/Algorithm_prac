#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool compare(int a, int b) {
    return a > b; 
}

vector<int> solution(vector<int> answers) {
    vector<int> answer;
    int arr1[5] = {1,2,3,4,5};
    int arr2[8] = {2,1,2,3,2,4,2,5};
    int arr3[10] = {3,3,1,1,2,2,4,4,5,5};
    int arr4[3] = {0,0,0};
    int cnt1 = 0; int cnt2 = 0; int cnt3 = 0;
    for(int i = 0 ; i<answers.size() ; i++){
        int tmp = answers[i];
        if(arr1[cnt1]==tmp){
            arr4[0] = arr4[0]+1;
        }
        if(arr2[cnt2]==tmp){
            arr4[1] = arr4[1]+1;
        }
        if(arr3[cnt3]==tmp){
            arr4[2] = arr4[2]+1;
        }
        cnt1++; cnt2++; cnt3++;
        if(cnt1==5) cnt1 = 0;
        if(cnt2==8) cnt2 = 0;
        if(cnt3==10) cnt3 = 0;
    }
    
    int maxa = 0;
    for(int i = 0; i<3 ; i++) {
        if(maxa<arr4[i]) maxa = arr4[i]; 
    }
    for(int i = 0 ; i<3; i++){
        if(maxa==arr4[i]) answer.push_back(i+1);
    }
    
    return answer;
}
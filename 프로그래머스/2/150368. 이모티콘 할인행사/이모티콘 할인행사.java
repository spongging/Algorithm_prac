import java.util.*;

class Solution {
    private int[] percent = {10, 20, 30, 40};
    private int[] answer = {0, 0};
    private ArrayList<Integer> percentArr = new ArrayList<>();
    
    public int[] solution(int[][] users, int[] emoticons) {
        dfs(0, emoticons.length, users, emoticons);
        return answer;
    }
    
    private void dfs(int level, int emoticonsSize, int[][] users, int[] emoticons){
        if(level == emoticonsSize){
            calculate(users, emoticons);
            return;
        }
        
        for(int i = 0 ; i < 4 ; i++){
            percentArr.add(percent[i]);
            dfs(level+1, emoticonsSize, users, emoticons);
            percentArr.remove(percentArr.size()-1);
        }
        
        return;
    }
    
    private void calculate(int[][] users, int[] emoticons){
        ArrayList<Integer> saledEmoticons = new ArrayList<>(); // 할인된 가격
        int cnt = 0; // 이모티콘 플러스 가입 사용자 수
        int total = 0; // 총 판매액 
        
        for(int i = 0 ; i < percentArr.size() ; i++){
            int rate = percentArr.get(i);
            int price = emoticons[i]*(100-rate)/100;
            
            saledEmoticons.add(price);
        }
        
        for(int i = 0 ; i < users.length ; i++){
            int tmpTotal = 0;
            for(int j = 0 ; j < saledEmoticons.size() ; j++){
                if(users[i][0] > percentArr.get(j)){
                    continue;
                }
                
                tmpTotal += saledEmoticons.get(j);
            }
            
            if(tmpTotal >= users[i][1]){
                cnt++;
            }else{
                total+=tmpTotal;
            }
        }
        
        if(answer[0] < cnt || (answer[0] == cnt && answer[1] < total)){
            answer[0] = cnt;
            answer[1] = total;
        }
        
        return;
    }
}
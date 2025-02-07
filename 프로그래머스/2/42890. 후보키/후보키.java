import java.util.*;

class Solution {
    private ArrayList<String> answer = new ArrayList<>();
    private ArrayList<String> combList;
    private int degree;
    private int cardinality;
    private String[][] relation;
    
    public int solution(String[][] relation) {
        this.relation = relation;
        degree = relation[0].length;
        cardinality = relation.length;
        
        for(int i = 1 ; i <= degree ; i++){
            combList = new ArrayList<>();
            
            comb(0, i, "");
            isCorrect();    
        }
        return answer.size();
    }
    
    private void comb(int start, int level, String tmp){
        if(level==0){
            combList.add(tmp);
            return;
        }
        
        for(int i = start ; i < degree ; i++ ){
            comb(i+1, level-1 , tmp+i);
        }
    }
    
    private void isCorrect(){
        for(String s : combList){
            Set<String> set = new HashSet<>();
            
            for(int i = 0 ; i < cardinality ; i++){
                String tmp = "";
                for(int j = 0 ; j < s.length() ; j++){
                    tmp+=relation[i][s.charAt(j) - '0'];
                }  
                set.add(tmp);
            }
            
            if(set.size()!=cardinality){
                continue;
            }
            
            boolean TF = false;
            for(String s1 : answer){
                int cnt = 0; 
                for(int i  = 0 ; i < s1.length() ; i++){
                    for(int j = 0 ; j < s.length() ; j++){
                        if(s.charAt(j)==s1.charAt(i)){
                            cnt++;
                        }
                    }
                }
                if(cnt==s1.length()){
                    TF = true;
                }
            }
            if(!TF){
                answer.add(s);
            }
            
        }
    }
}
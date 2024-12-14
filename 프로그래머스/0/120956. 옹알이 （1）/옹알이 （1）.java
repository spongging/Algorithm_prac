class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] words = {"aya","ye","woo","ma"};
        for(String s : babbling){
            for(String w : words){
                s=s.replace(w," ");
            }
            if(s.trim().isEmpty()){
                answer++;
            }
        }
        return answer;   
    }
}
class Solution {
    public int solution(String s) {
        int answer = 0;
        int prevNum = 0;
        String num="";
        for(int i = 0 ; i<s.length() ; i++){
            char c = s.charAt(i);
            if(c==' '){
                if(num.isEmpty()) continue;
                int tmp = Integer.parseInt(num);
                answer+=tmp;
                num = "";
                prevNum = tmp;
            }
            else if(Character.isDigit(c)|| c=='-'){
                num+=c;
            }
            else if(c=='Z'){
                answer-=prevNum;
            }
        }
        if (!num.isEmpty()) {
            int tmp = Integer.parseInt(num);
            answer += tmp;
        }
        return answer;
    }
}
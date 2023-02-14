class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[] score = new int[3];
        int idx = 0;
        
        for(int i=0; i<dartResult.length(); i++){
            char c = dartResult.charAt(i);
            
            if(c >= '0' && c <= '9'){
                char next = dartResult.charAt(i+1);
                if(next == '0') {
                    score[idx] = 10;
                    i++;
                } else{
                    score[idx] = c - '0';
                }
            } 
            else if(c >= 'A' && c <= 'z'){
                if(c == 'S') {
                    score[idx] = (int) Math.pow(score[idx], 1);
                }
                else if(c == 'D') {
                    score[idx] = (int) Math.pow(score[idx], 2);
                }
                else if(c == 'T') {
                    score[idx] = (int) Math.pow(score[idx], 3);
                }
                if(i != dartResult.length()-1){
                    char next = dartResult.charAt(i+1);
                    if(next >= '0' && next <= '9'){
                        idx++;
                    }
                }
            }
            else if(c == '*'){
                if(idx == 0) score[idx] *= 2;
                else {
                    score[idx-1] *= 2;
                    score[idx] *= 2;
                }
                idx++;
            }
            else if(c == '#'){
                score[idx] = -score[idx];
                idx++;
            }
        }
        
        answer = score[0] + score[1] + score[2];
        return answer;
    }
}
class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        
        int len = number.length() - k;
        int start = 0;
        for(int i=0; i<len; i++){
            int max = 0;
            for(int j=start; j<=i+k; j++){
                int num = number.charAt(j) - '0';
                if(max < num){
                    max = num;
                    start = j+1;
                }
            }
            answer.append(max);
        }
        
        return answer.toString();
    }
}
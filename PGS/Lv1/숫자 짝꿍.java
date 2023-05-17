class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        
        int[] X_count = new int[10];
        int[] Y_count = new int[10];
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<X.length(); i++){
            X_count[X.charAt(i) - '0']++;
        }
        
        for(int i=0; i<Y.length(); i++){
            Y_count[Y.charAt(i) - '0']++;
        }
        
        boolean flag = false;
        for(int i=9; i>=0; i--){
            if(X_count[i] != 0 && Y_count[i] != 0){
                int min = Math.min(X_count[i], Y_count[i]);
                
                for(int j=0; j<min; j++){
                    sb.append(i);
                }
            }
        }
        answer = sb.toString();
        if(answer.equals("")) answer = "-1";
        else if(sb.charAt(0) == '0') answer = "0";
        
        return answer;
    }
}
class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        int endNumIdx = t * m;
        char[] numArr = new char[endNumIdx+1];
        
        numArr[0] = '0';
        int num = 0;
        int idx = 1;
        while(endNumIdx > 0){
            String strNum = "";
            
            int temp = num;
            
            while(temp > 0){
                if(temp%n >= 10){
                    strNum = (char) ((temp%n - 10) + 'A') + strNum;
                } else {
                    strNum = temp%n + strNum;
                }
                temp /= n;
            }
            
            for(int i=0; i<strNum.length(); i++){
                numArr[idx++] = strNum.charAt(i);
                endNumIdx--;
                if(endNumIdx == 0) break;
            }
            num++;
        }
        
        for(int i=0; i<t; i++){
            answer += numArr[i*m + (p-1)];
        }
        
        return answer;
    }
}
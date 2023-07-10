class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        
        String[] digit = {"4", "1", "2"};
        
        while(n > 0){
            int tmp = n%3;
            n /= 3;
            if(tmp == 0){ 
                n--;
            }
            answer.insert(0, digit[tmp]);
        }
            
        return answer.toString();
    }
}
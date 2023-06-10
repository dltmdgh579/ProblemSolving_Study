class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int xCount = 1;
        int nonXCount = 0;
        
        if(s.length() == 1) return 1;
        
        char x = s.charAt(0);
        for(int i=1; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == x){
                xCount++;
            } else {
                nonXCount++;
            }
            if(i+1 == s.length() && xCount != nonXCount) {
                answer++;
                break;
            }
            if(xCount == nonXCount){
                answer++;
                if(i+1 == s.length()) break;
                x = s.charAt(i+1);
                xCount = 0;
                nonXCount = 0;
            }
        }
        
        return answer;
    }
}
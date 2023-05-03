class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        
        int start = section[0];
        
        for(int i=1; i<section.length; i++){
            int end = start + m - 1;
            
            if(section[i] >= start && section[i] <= end){
                continue;
            }
            
            answer++;
            start = section[i];
        }
        
        return answer;
    }
}
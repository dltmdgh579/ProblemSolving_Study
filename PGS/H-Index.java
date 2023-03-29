import java.util.Arrays;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        int min = Integer.MAX_VALUE;
        
        for(int i=citations.length-1; i>=0; i--){
            min = Math.min(citations[i], citations.length-i);
            answer = Math.max(answer, min);
        }
        
        return answer;
    }
}
import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        int div = s/n;
        int mod = s%n;
        
        for(int i=0; i<n; i++){
            answer[i] = div;
        }
        
        if(mod != 0){
            for(int i=0; i<mod; i++){
                answer[n-i-1] += 1;
            }
        }
        
        
        if(div == 0){
            answer = new int[] {-1};
        }
        
        return answer;
    }
}
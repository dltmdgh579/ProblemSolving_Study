import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        int[] deploy = new int[progresses.length];
        
        for(int i=0; i<progresses.length; i++){
            int dayCount = 0;
            
            while(progresses[i] < 100){
                progresses[i] += speeds[i];
                dayCount += 1;
            }
            
            deploy[i] = dayCount;
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<deploy.length; i++){
            int n = i;
            int count = 1;
            while(n+1 < deploy.length){
                if(deploy[i] >= deploy[n+1]) {
                    n += 1;
                    count += 1;
                } else {
                    break;
                }
                
            }
            i = n;
            list.add(count);
        }
        
        answer = new int[list.size()];
        
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;  
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int score : scoville){
            pq.add(score);
        }
        
        while(pq.peek() < K){
            if(pq.size() < 2) return -1;
            int min1 = pq.poll();
            int min2 = pq.poll();
            
            int mix = min1 + min2 * 2;
            pq.add(mix);
            answer++;
        }
        
        return answer;
    }
}
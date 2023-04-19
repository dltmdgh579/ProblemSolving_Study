import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int idx = 0;
        for(int n : score){
            pq.add(n);
            
            if(pq.size() > k){
                pq.poll();
            }
            
            answer[idx++] = pq.peek();
        }
        
        return answer;
    }
}
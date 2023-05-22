import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        for(int work : works){
            pq.add(work);
        }
        
        while(n > 0){
            int work = pq.poll();
            work--;
            n--;
            if(work < 0) break;
            pq.add(work);
        }
        
        for(int work : pq){
            answer += Math.pow(work, 2);
        }
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        
        PriorityQueue<Integer> min_pq = new PriorityQueue<>();
        PriorityQueue<Integer> max_pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String operation : operations){
            StringTokenizer st = new StringTokenizer(operation);
            
            String oper = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            
            if(oper.equals("I")){
                min_pq.add(num);
                max_pq.add(num);
            } else {
                if(min_pq.isEmpty() || max_pq.isEmpty()) continue;
                if(num == 1){
                    int max = max_pq.poll();
                    min_pq.remove(max);
                } else {
                    int min = min_pq.poll();
                    max_pq.remove(min);
                }
            }
        }
        
        if(min_pq.isEmpty() || max_pq.isEmpty()){
            answer = new int[] {0, 0};
        } else {
            answer = new int[] {max_pq.poll(), min_pq.poll()};
        }
        return answer;
        
    }
}
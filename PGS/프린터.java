import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<MaxValue> q = new LinkedList<>();
        
        for(int i=0; i<priorities.length; i++){
            q.add(new MaxValue(priorities[i], i));
        }
        
        while(!q.isEmpty()){
            MaxValue cur = q.peek();
            
            boolean flag = false;
            for(MaxValue mv : q){
                if(mv.value > cur.value){
                    flag = true;
                    break;
                }
            }
            
            if(flag){
                MaxValue tmp = q.poll();
                q.add(tmp);
            } else {
                q.poll();
                answer++;
                if(cur.index == location) break;
            }
        }
        
        return answer;
    }
    
    class MaxValue{
        int value, index;
        
        public MaxValue(int value, int index){
            this.value = value;
            this.index = index;
        }
    }
}
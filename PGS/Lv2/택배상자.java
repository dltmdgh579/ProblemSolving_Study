import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        int idx = 0;
        for(int i=1; i<=order.length; i++){
            boolean flag = false;
            
            if(i == order[idx]){
                answer++;
                idx++;
                flag = true;
            }
            
            while(!stack.isEmpty() && stack.peek() == order[idx]){
                stack.pop();
                answer++;
                idx++;
                flag = true;
            } 
            
            if(!flag) {
                stack.add(i);
            }
        }
        
        while(!stack.isEmpty() && stack.peek() == order[idx]){
            stack.pop();
            answer++;
            idx++;
        }
        
        return answer;
    }
}
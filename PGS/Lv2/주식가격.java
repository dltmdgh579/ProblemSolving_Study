import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<int[]> stack = new Stack<>();
        
        stack.add(new int[] {0, prices[0]});
        
        for(int i=1; i<prices.length; i++){
            if(prices[i] > stack.peek()[1]){
                stack.add(new int[] {i, prices[i]});
            } else {
                while(!stack.isEmpty() && prices[i] < stack.peek()[1]){
                    int idx = stack.pop()[0];
                    answer[idx] = i - idx;
                }
                stack.add(new int[] {i, prices[i]});
            }
        }
        
        while(!stack.isEmpty()){
            int idx = stack.pop()[0];
            answer[idx] = prices.length - idx - 1;
        }
        
        return answer;
    }
}
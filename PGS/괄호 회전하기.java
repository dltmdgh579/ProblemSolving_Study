import java.util.Stack;

class Solution {
    static Stack<Character> stack;
    static StringBuilder sb;
    static int answer;
    public int solution(String s) {
        
        stack = new Stack<>();
        
        sb = new StringBuilder(s);
        
        for(int i=0; i<s.length(); i++){
            check();
            rotation();
        }
        
        return answer;
    }
    
    public void check(){
        stack = new Stack<>();
        for(int i=0; i<sb.length(); i++){
            char c = sb.charAt(i);
            if(c == '(' || c == '{' || c == '[') stack.push(c);
            
            if(c == ')' || c == '}' || c == ']'){
                if(stack.isEmpty()) return;
            }
            
            if(c == ')'){
                if(stack.peek() == '('){
                    stack.pop();
                } else {
                    return;
                }
            } else if(c == '}'){
                if(stack.peek() == '{'){
                    stack.pop();
                } else {
                    return;
                }
            } else if(c == ']'){
                if(stack.peek() == '['){
                    stack.pop();
                } else {
                    return;
                }
            }
        }
        if(!stack.isEmpty()) return;
        answer++;
    }
    
    public void rotation(){
        sb.append(sb.charAt(0)).deleteCharAt(0);
    }
}
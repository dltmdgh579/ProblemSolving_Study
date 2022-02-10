import java.util.Scanner;
import java.util.Stack;
 
public class BOJ_2504 {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        
        Stack<String> stack = new Stack<String>();
        
        boolean flag = true;
        for(int i=0; i < str.length(); i++) {
            String c = str.substring(i, i+1);
            
            if("(".equals(c)) {
                stack.push("(");
                continue;
            }
            
            if("[".equals(c)) {
                stack.push("[");
                continue;
            }

            int num = 0;
            while(true) {
                if(stack.isEmpty()) {
                    flag = false;
                    break;
                }
                
                if(!(stack.peek().equals("(") || stack.peek().equals("["))) {
                    num += Integer.parseInt(stack.pop());
                }else {
                    if(c.equals(")")) {
                        if(stack.peek().equals("(")){
                            stack.pop();
                            int t = 2;
                            
                            if(num == 0) {
                                stack.push(String.valueOf(t)); 
                            }else {
                                stack.push(String.valueOf(t*num));
                            }
                            break;
                        }
                        else {
                            flag = false;
                            break;
                        }
                    }
                    else if(c.equals("]")) {
                        if(stack.peek().equals("[")){
                            stack.pop();
                            int t = 3;
                            
                            if(num == 0) {
                                stack.push(String.valueOf(t)); 
                            }else {
                                stack.push(String.valueOf(t*num));
                            }
                            break;
                        }
                        else {
                            flag = false;
                            break;
                        }
                    }
                }
            }
            if(!flag) break;
        }
        
        int result = 0;
        
        while(!stack.isEmpty()) {
            if(!(stack.peek().equals("(") || stack.peek().equals("["))) {
                result += Integer.parseInt(stack.pop());
            }else {
                flag = false;
                break;
            }
        }
        
        System.out.println(flag?result:0);
    }
}
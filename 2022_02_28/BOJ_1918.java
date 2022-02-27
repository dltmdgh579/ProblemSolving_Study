import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1918 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);

            // 연산자일 경우
            if(c == '+' || c == '-' || c == '*' || c == '/'){
                // 스택이 비어있지 않고(연산자 첫 입력) 스택 상단의 연산자보다 우선순위가 낮을 경우
                while(!stack.isEmpty() && priority(stack.peek()) >= priority(c)){
                    // append
                    sb.append(stack.pop());
                } // 연산 한 덩이 완료

                // 현재 연산자 push
                stack.push(c);
            }
            // 괄호일 경우
            else if(c == '(') stack.push(c);
            else if(c == ')'){
                // 여는 괄호가 나오기 전까지 append
                while(!stack.isEmpty() && stack.peek() != '('){
                    sb.append(stack.pop());
                }
                // 여는 괄호 삭제
                stack.pop();
            }
            // 피연산자일 경우
            else sb.append(c);
        }

        // 스택에 남아있는 모든 연산자 append
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        //출력
        System.out.println(sb.toString());
    }
    
    // 우선순위 정의
    public static int priority(char c){
        if(c == '(' || c == ')') return 0; // 괄호 다음의 연산자를 넣기 위해
        else if(c == '+' || c == '-') return 1;
        else return 2;
    }
}

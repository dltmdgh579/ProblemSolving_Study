import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10799 {
    
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        int cur = 0;
        int answer = 0;

        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);

            if(c == '('){
                stack.push(c);
                cur++;
                answer++;
            } else {
                if(stack.peek() == '('){
                    cur--;
                    answer--;
                    answer += cur;
                    stack.push(c);
                } else {
                    cur--;
                }
            }
        }
        System.out.println(answer);
    }
}